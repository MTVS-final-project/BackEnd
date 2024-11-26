package com.ohgiraffers.hellocat.market.service;

import com.ohgiraffers.hellocat.market.dto.MarketRoomRequestDto;
import com.ohgiraffers.hellocat.market.dto.MarketRoomResponseDto;
import com.ohgiraffers.hellocat.market.dto.MarketRoomTradeResponseDto;
import com.ohgiraffers.hellocat.market.entity.MarketRoom;
import com.ohgiraffers.hellocat.market.repository.MarketRoomRepository;
import com.ohgiraffers.hellocat.room.dto.RoomResponseDto;
import com.ohgiraffers.hellocat.room.entity.Room;
import com.ohgiraffers.hellocat.room.repository.RoomRepository;
import com.ohgiraffers.hellocat.room.service.RoomService;
import com.ohgiraffers.hellocat.user.entity.User;
import com.ohgiraffers.hellocat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MarketRoomService {

    private final MarketRoomRepository marketRoomRepository;
    private final RoomService roomService;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public MarketRoomResponseDto createMarketRoom(String roomId, Long price) {

        // 해당 아이디를 가진 룸을 찾기
        RoomResponseDto foundRoom = roomService.findRoomById(roomId);

        // 찾은 룸을 바탕으로 요청 DTO 생성
        MarketRoomRequestDto requestDto = new MarketRoomRequestDto(foundRoom, price);

        MarketRoom savedMarketRoom = marketRoomRepository.save(new MarketRoom(requestDto));

        return new MarketRoomResponseDto(savedMarketRoom);
    }

    public List<MarketRoomResponseDto> findMarketRoomList() {

        return marketRoomRepository.findAll()
                .stream()
                .map(MarketRoomResponseDto::new)
                .toList();
    }

    public void deleteMarketRoom(String marketRoomId) {

        MarketRoom foundMarketRoom = marketRoomRepository.findById(marketRoomId)
                .orElseThrow(() -> {
                    log.error("룸을 찾을 수 없습니다. marketRoomId={}", marketRoomId);
                    return new IllegalArgumentException("룸을 찾을 수 없습니다.");
                });

        marketRoomRepository.delete(foundMarketRoom);
    }

    public MarketRoomTradeResponseDto tradeMarketRoom(String marketRoomId, Long userId) {

        MarketRoom foundMarketRoom = marketRoomRepository.findById(marketRoomId)
                .orElseThrow(() -> {
                    log.error("룸을 찾을 수 없습니다. marketRoomId={}", marketRoomId);
                    return new IllegalArgumentException("룸을 찾을 수 없습니다.");
                });

        User buyer = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("유저를 찾을 수 없습니다. userId={}", userId);
                    return new IllegalArgumentException("유저를 찾을 수 없습니다.");
                });

        Long makerId = foundMarketRoom.getMakerId();
        User maker = userRepository.findById(makerId)
                .orElse(null);
        
        Long buyerId = buyer.getId();

        if (buyerId.equals(makerId)) {
            throw new IllegalArgumentException("본인의 룸은 구매할 수 없습니다.");
        }
        
        // 구매 룸 가격
        Long foundMarketRoomPrice = foundMarketRoom.getPrice();
        
        // 구매자 코인 감소
        buyer.removeCoin(foundMarketRoomPrice);

        Room newRoom = new Room(foundMarketRoom, buyerId);
        roomRepository.save(newRoom);

        // 판매자 코인 추가
        if (maker != null) {
            maker.addCoin(foundMarketRoomPrice);
        }

        return null;
    }
}

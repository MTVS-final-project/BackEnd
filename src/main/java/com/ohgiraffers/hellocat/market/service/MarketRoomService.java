package com.ohgiraffers.hellocat.market.service;

import com.ohgiraffers.hellocat.market.dto.MarketRoomRequestDto;
import com.ohgiraffers.hellocat.market.dto.MarketRoomResponseDto;
import com.ohgiraffers.hellocat.market.entity.MarketRoom;
import com.ohgiraffers.hellocat.market.repository.MarketRoomRepository;
import com.ohgiraffers.hellocat.room.dto.RoomResponseDto;
import com.ohgiraffers.hellocat.room.service.RoomService;
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
}

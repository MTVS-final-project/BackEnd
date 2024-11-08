package com.ohgiraffers.hellocat.market.service;

import com.ohgiraffers.hellocat.market.dto.MarketItemRequestDto;
import com.ohgiraffers.hellocat.market.dto.MarketItemResponseDto;
import com.ohgiraffers.hellocat.market.dto.MarketItemTradeResponseDto;
import com.ohgiraffers.hellocat.market.entity.MarketItem;
import com.ohgiraffers.hellocat.market.repository.MarketItemRepository;
import com.ohgiraffers.hellocat.user.entity.User;
import com.ohgiraffers.hellocat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MarketItemService {

    private final MarketItemRepository marketItemRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<MarketItemResponseDto> findMarketItemList() {

        return marketItemRepository.findAll()
                .stream()
                .map(MarketItemResponseDto::new)
                .collect(Collectors.toList());
    }

    public MarketItemResponseDto createMarketItem(MarketItemRequestDto requestDto) {

        MarketItem marketItem = new MarketItem(requestDto);

        MarketItem savedItem = marketItemRepository.save(marketItem);

        return new MarketItemResponseDto(savedItem);
    }

    public MarketItemResponseDto updateMarketItem(Long itemId, MarketItemRequestDto requestDto) {

        MarketItem foundItem = marketItemRepository.findById(itemId)
                .orElseThrow(() -> {
                    log.error("아이템을 찾을 수 없습니다. itemId={}", itemId);
                    return new IllegalArgumentException("아이템을 찾을 수 없습니다.");
                });

        MarketItem updatedItem = foundItem.update(requestDto);

        return new MarketItemResponseDto(updatedItem);
    }

    public void deleteMarketItem(Long itemId) {

        MarketItem foundItem = marketItemRepository.findById(itemId)
                .orElseThrow(() -> {
                    log.error("아이템을 찾을 수 없습니다. itemId={}", itemId);
                    return new IllegalArgumentException("아이템을 찾을 수 없습니다.");
                });

        marketItemRepository.delete(foundItem);
    }

    public MarketItemTradeResponseDto tradeMarketItem(Long itemId) {

        MarketItem foundItem = marketItemRepository.findById(itemId)
                .orElseThrow(() -> {
                    log.error("아이템을 찾을 수 없습니다. itemId={}", itemId);
                    return new IllegalArgumentException("아이템을 찾을 수 없습니다.");
                });

        Long makerId = foundItem.getMakerId();
        Long foundItemPrice = foundItem.getPrice();

        User maker = userRepository.findById(makerId)
                .orElse(null);
        
        // Todo: 구매 유저 코인 감소 로직, 아이템 추가 로직
        // buyer.removeCoin(foundItemPrice);

        // 판매 유저 코인 추가 로직
        if (maker != null) {
            maker.addCoin(foundItemPrice);
        }

        // 리턴용 DTO 세팅
        MarketItemTradeResponseDto responseDto = new MarketItemTradeResponseDto(foundItem);
        responseDto.setMakerId(makerId);

        return responseDto;
    }
}

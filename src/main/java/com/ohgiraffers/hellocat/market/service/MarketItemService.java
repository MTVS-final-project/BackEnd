package com.ohgiraffers.hellocat.market.service;

import com.ohgiraffers.hellocat.market.dto.MarketItemResponseDto;
import com.ohgiraffers.hellocat.market.repository.MarketItemRepository;
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

    @Transactional(readOnly = true)
    public List<MarketItemResponseDto> findMarketItemList() {

        return marketItemRepository.findAll()
                .stream()
                .map(MarketItemResponseDto::new)
                .collect(Collectors.toList());
    }
}

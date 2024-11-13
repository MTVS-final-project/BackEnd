package com.ohgiraffers.hellocat.item.service;

import com.ohgiraffers.hellocat.item.dto.ItemRequestDto;
import com.ohgiraffers.hellocat.item.dto.ItemResponseDto;
import com.ohgiraffers.hellocat.item.entity.Item;
import com.ohgiraffers.hellocat.item.repository.ItemRepository;
import com.ohgiraffers.hellocat.market.entity.MarketItem;
import com.ohgiraffers.hellocat.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto buyItem(MarketItem foundItem, User buyer) {

        ItemRequestDto requestDto = new ItemRequestDto(foundItem, buyer);

        Item item = new Item(requestDto);

        Item savedItem = itemRepository.save(item);

        return new ItemResponseDto(savedItem);
    }
}

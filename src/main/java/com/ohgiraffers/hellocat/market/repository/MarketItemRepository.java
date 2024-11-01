package com.ohgiraffers.hellocat.market.repository;

import com.ohgiraffers.hellocat.market.entity.MarketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketItemRepository extends JpaRepository<MarketItem, Long> {
}

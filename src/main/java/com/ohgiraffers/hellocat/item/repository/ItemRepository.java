package com.ohgiraffers.hellocat.item.repository;

import com.ohgiraffers.hellocat.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

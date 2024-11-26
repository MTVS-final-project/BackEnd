package com.ohgiraffers.hellocat.market.repository;

import com.ohgiraffers.hellocat.market.entity.MarketRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarketRoomRepository extends MongoRepository<MarketRoom, String> {
}

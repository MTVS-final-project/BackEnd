package com.ohgiraffers.hellocat.room.repository;

import com.ohgiraffers.hellocat.room.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}

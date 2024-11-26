package com.ohgiraffers.hellocat.room.repository;

import com.ohgiraffers.hellocat.room.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room, String> {

    List<Room> findAllByOwnerId(Long ownerId);
}

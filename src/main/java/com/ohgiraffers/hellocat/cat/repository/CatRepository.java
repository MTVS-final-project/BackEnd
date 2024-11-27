package com.ohgiraffers.hellocat.cat.repository;

import com.ohgiraffers.hellocat.cat.entity.Cat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CatRepository extends MongoRepository<Cat, String> {

    Optional<Cat> findCatByOwnerId(Long ownerId);
}

package com.ohgiraffers.hellocat.character.repository;

import com.ohgiraffers.hellocat.character.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    Optional<Character> findByUserId(Long userId);
}

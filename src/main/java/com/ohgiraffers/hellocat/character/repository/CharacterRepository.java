package com.ohgiraffers.hellocat.character.repository;

import com.ohgiraffers.hellocat.character.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    Character findByUserId(Long userId);
}

package com.ohgiraffers.hellocat.character.service;

import com.ohgiraffers.hellocat.character.dto.CharacterUpdateRequestDto;
import com.ohgiraffers.hellocat.character.dto.CharacterUpdateResponseDto;
import com.ohgiraffers.hellocat.character.entity.Character;
import com.ohgiraffers.hellocat.character.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterUpdateResponseDto update(Long userId, CharacterUpdateRequestDto requestDto) {

        Character foundCharacter = characterRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        return foundCharacter.update(requestDto);
    }
}

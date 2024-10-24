package com.ohgiraffers.hellocat.character.service;

import com.ohgiraffers.hellocat.character.dto.CharacterUpdateRequestDto;
import com.ohgiraffers.hellocat.character.dto.CharacterUpdateResponseDto;
import com.ohgiraffers.hellocat.character.entity.Character;
import com.ohgiraffers.hellocat.character.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public Long createCharacter(Character character) {
        return characterRepository.save(character).getId();
    }

    public CharacterUpdateResponseDto update(Long characterId, CharacterUpdateRequestDto requestDto) {

        Character foundCharacter = characterRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("캐릭터를 찾을 수 없습니다."));

        foundCharacter.update(requestDto);

        return CharacterUpdateResponseDto.builder()
                .skin(foundCharacter.getSkin())
                .hair(foundCharacter.getHair())
                .eye(foundCharacter.getEye())
                .mouth(foundCharacter.getMouth())
                .leftArm(foundCharacter.getLeftArm())
                .rightArm(foundCharacter.getRightArm())
                .pants(foundCharacter.getPants())
                .leftLeg(foundCharacter.getLeftLeg())
                .rightLeg(foundCharacter.getRightLeg())
                .leftShoe(foundCharacter.getLeftShoe())
                .rightShoe(foundCharacter.getRightShoe())
                .build();
    }
}

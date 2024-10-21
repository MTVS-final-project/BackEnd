package com.ohgiraffers.hellocat.character.controller;

import com.ohgiraffers.hellocat.character.dto.CharacterUpdateRequestDto;
import com.ohgiraffers.hellocat.character.dto.CharacterUpdateResponseDto;
import com.ohgiraffers.hellocat.character.entity.Character;
import com.ohgiraffers.hellocat.character.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/character")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @PostMapping("/{userId}")
    @Operation(summary = "유저 캐릭터 업데이트", description = "유저의 캐릭터 커스터마이징을 업데이트 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 캐릭터 업데이트 성공"),
            @ApiResponse(responseCode = "404", description = "유저를 찾을 수 없음")
    })
    public ResponseEntity<CharacterUpdateResponseDto> updateCharacter(@PathVariable Long userId,
                                                     @RequestBody CharacterUpdateRequestDto requestDto) {

        CharacterUpdateResponseDto updatedCharacter = characterService.update(userId, requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(updatedCharacter);
    }
}

package com.ohgiraffers.hellocat.character.controller;

import com.ohgiraffers.hellocat.character.dto.CharacterUpdateRequestDto;
import com.ohgiraffers.hellocat.character.dto.CharacterUpdateResponseDto;
import com.ohgiraffers.hellocat.character.service.CharacterService;
import com.ohgiraffers.hellocat.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "캐릭터 API", description = "유저의 캐릭터 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/character")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;
    private final UserService userService;

    @PostMapping("/{userId}")
    @Operation(summary = "유저 캐릭터 업데이트", description = "유저의 캐릭터 커스터마이징을 업데이트 합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 캐릭터 업데이트 성공"),
            @ApiResponse(responseCode = "404", description = "유저를 찾을 수 없음")
    })
    public ResponseEntity<CharacterUpdateResponseDto> updateCharacter(@PathVariable Long userId,
                                                     @RequestBody CharacterUpdateRequestDto requestDto) {

        Long characterId = userService.findById(userId).getCharacter().getId();

        CharacterUpdateResponseDto updatedCharacter = characterService.update(characterId, requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(updatedCharacter);
    }
}

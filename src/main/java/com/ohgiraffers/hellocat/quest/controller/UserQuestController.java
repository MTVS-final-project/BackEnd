package com.ohgiraffers.hellocat.quest.controller;

import com.ohgiraffers.hellocat.quest.dto.UserQuestRequestDto;
import com.ohgiraffers.hellocat.quest.dto.UserQuestResponseDto;
import com.ohgiraffers.hellocat.quest.service.UserQuestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "유저 퀘스트 API", description = "유저 퀘스트 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/quest")
@RequiredArgsConstructor
public class UserQuestController {

    private final UserQuestService userQuestService;

    @GetMapping
    @Operation(summary = "유저 생성 퀘스트 조회", description = "유저가 생성한 퀘스트를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 퀘스트 조회 성공, 퀘스트가 없는 경우 빈 리스트 반환"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<List<UserQuestResponseDto>> findUserQuestList() {

        List<UserQuestResponseDto> responseDtoList = userQuestService.findUserQuestList();

        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "특정 유저 생성 퀘스트 조회", description = "특정 유저가 생성한 퀘스트를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "유저 퀘스트 조회 성공, 퀘스트가 없는 경우 빈 리스트 반환"),
            @ApiResponse(responseCode = "404", description = "유저를 찾을 수 없습니다."),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<List<UserQuestResponseDto>> findUserQuestByUserId(@PathVariable Long userId) {

        List<UserQuestResponseDto> responseDtoList = userQuestService.findUserQuestByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @PostMapping
    @Operation(summary = "유저 퀘스트 생성", description = "유저가 퀘스트를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "퀘스트가 정상 조회되었습니다.")
    })
    public ResponseEntity<UserQuestResponseDto> createUserQuest(@RequestBody UserQuestRequestDto requestDto) {

        UserQuestResponseDto savedQuest = userQuestService.createUserQuest(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuest);
    }
}


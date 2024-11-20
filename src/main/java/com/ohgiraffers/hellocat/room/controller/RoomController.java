package com.ohgiraffers.hellocat.room.controller;

import com.ohgiraffers.hellocat.room.dto.RoomRequestDto;
import com.ohgiraffers.hellocat.room.dto.RoomResponseDto;
import com.ohgiraffers.hellocat.room.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "룸 API", description = "룸 저장 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    @Operation(summary = "룸 저장", description = "유저가 룸을 저장합니다.")
    @ApiResponse(responseCode = "201", description = "룸이 정상 저장되었습니다.")
    public ResponseEntity<RoomResponseDto> saveRoom(@RequestBody RoomRequestDto requestDto) {

        RoomResponseDto responseDto = roomService.saveRoom(requestDto);

        return ResponseEntity.status(201).body(responseDto);
    }
}

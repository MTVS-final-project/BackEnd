package com.ohgiraffers.hellocat.room.controller;

import com.ohgiraffers.hellocat.room.dto.RoomRequestDto;
import com.ohgiraffers.hellocat.room.dto.RoomResponseDto;
import com.ohgiraffers.hellocat.room.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

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

    @GetMapping
    @Operation(summary = "아이디 기반 룸 조회", description = "룸의 ID를 기반으로 룸을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "룸 조회 성공"),
            @ApiResponse(responseCode = "404", description = "룸을 찾을 수 없습니다.")
    })
    public ResponseEntity<RoomResponseDto> findRoomById(@RequestParam String roomId) {

        try {
            RoomResponseDto responseDto = roomService.findRoomById(roomId);
            return ResponseEntity.status(OK).body(responseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }

    @GetMapping("/{ownerId}")
    @Operation(summary = "제작자 기반 룸 전체 조회", description = "해당 아이디를 가진 유저의 룸을 모두 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "룸 조회 성공"),
            @ApiResponse(responseCode = "404", description = "유저를 찾을 수 없습니다.")
    })
    public ResponseEntity<List<RoomResponseDto>> findRoomByMakerId(@PathVariable Long ownerId) {

        try {
            List<RoomResponseDto> responseDtoList = roomService.findRoomByMakerId(ownerId);
            return ResponseEntity.status(OK).body(responseDtoList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
}

package com.ohgiraffers.hellocat.market.controller;

import com.ohgiraffers.hellocat.market.dto.MarketRoomRequestDto;
import com.ohgiraffers.hellocat.market.dto.MarketRoomResponseDto;
import com.ohgiraffers.hellocat.market.service.MarketRoomService;
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

import static org.springframework.http.HttpStatus.*;

@Tag(name = "마켓 룸 거래 API", description = "마켓의 룸 거래 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/market/room")
@RequiredArgsConstructor
public class MarketRoomController {

    private final MarketRoomService marketRoomService;

    @PostMapping
    @Operation(summary = "마켓 아이템 생성", description = "마켓 아이템을 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "마켓 아이템 생성 성공"),
            @ApiResponse(responseCode = "404", description = "룸을 찾을 수 없습니다.")
    })
    public ResponseEntity<MarketRoomResponseDto> createMarketRoom(@RequestParam String roomId,
                                                                   @RequestParam Long price) {

        try {
            MarketRoomResponseDto createdMarketRoom = marketRoomService.createMarketRoom(roomId, price);
            return ResponseEntity.status(CREATED).body(createdMarketRoom);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }

    @GetMapping
    @Operation(summary = "마켓 룸 조회", description = "마켓의 모든 룸을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "마켓 아이템 조회 성공, 아이템이 없는 경우 빈 리스트 반환")
    })
    public ResponseEntity<List<MarketRoomResponseDto>> findMarketRoomList() {

        List<MarketRoomResponseDto> marketRoomList = marketRoomService.findMarketRoomList();

        return ResponseEntity.status(OK).body(marketRoomList);
    }
}

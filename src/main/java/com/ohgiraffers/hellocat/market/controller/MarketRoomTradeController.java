package com.ohgiraffers.hellocat.market.controller;

import com.ohgiraffers.hellocat.market.dto.MarketRoomTradeResponseDto;
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

import static org.springframework.http.HttpStatus.*;

@Tag(name = "마켓 아이템 거래 API", description = "마켓의 아이템 거래 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/market/trade/room")
@RequiredArgsConstructor
public class MarketRoomTradeController {

    private final MarketRoomService marketRoomService;

    @PostMapping("/{marketRoomId}")
    @Operation(summary = "마켓 룸 구매", description = "마켓 룸을 거래합니다. 구매 유저는 아이템을 얻고 돈을 잃습니다. 판매 유저는 돈이 오릅니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "거래 성공"),
            @ApiResponse(responseCode = "404", description = "아이템을 찾을 수 없습니다.")
    })
    public ResponseEntity<MarketRoomTradeResponseDto> tradeMarketRoom(
            @PathVariable String marketRoomId,
            @RequestParam Long userId) {

        try {
            MarketRoomTradeResponseDto responseDto = marketRoomService.tradeMarketRoom(marketRoomId, userId);
            return ResponseEntity.status(OK).body(responseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
}

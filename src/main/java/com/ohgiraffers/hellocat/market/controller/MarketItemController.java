package com.ohgiraffers.hellocat.market.controller;

import com.ohgiraffers.hellocat.market.dto.MarketItemResponseDto;
import com.ohgiraffers.hellocat.market.service.MarketItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Tag(name = "마켓 아이템 API", description = "마켓의 아이템 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/market/item")
@RequiredArgsConstructor
public class MarketItemController {

    private final MarketItemService marketItemService;

    @GetMapping
    @Operation(summary = "마켓 아이템 조회", description = "마켓의 모든 아이템을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "마켓 아이템 조회 성공, 아이템이 없는 경우 빈 리스트 반환")
    })
    public ResponseEntity<?> findMarketItemList() {

        List<MarketItemResponseDto> marketItemList = marketItemService.findMarketItemList();

        return ResponseEntity.status(OK).body(marketItemList);
    }
}

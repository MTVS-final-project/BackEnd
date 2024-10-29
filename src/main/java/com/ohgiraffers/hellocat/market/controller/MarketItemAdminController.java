package com.ohgiraffers.hellocat.market.controller;

import com.ohgiraffers.hellocat.market.dto.MarketItemRequestDto;
import com.ohgiraffers.hellocat.market.dto.MarketItemResponseDto;
import com.ohgiraffers.hellocat.market.service.MarketItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@Tag(name = "관리자 마켓 아이템 API", description = "관리자용 마켓 아이템 API, 관리 기능 다수")
@Slf4j
@RestController
@RequestMapping("/admin/api/v1/market/item")
@RequiredArgsConstructor
public class MarketItemAdminController {

    private final MarketItemService marketItemService;

    @PostMapping
    @Operation(summary = "마켓 아이템 생성", description = "마켓 아이템을 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "마켓 아이템 생성 성공")
    })
    public ResponseEntity<MarketItemResponseDto> createMarketItem(@RequestBody MarketItemRequestDto requestDto) {

        MarketItemResponseDto newItem = marketItemService.createMarketItem(requestDto);

        return ResponseEntity.status(CREATED).body(newItem);
    }
}

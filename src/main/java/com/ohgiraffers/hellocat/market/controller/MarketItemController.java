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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // Todo: 로그인 추가 이후 유저 인증 들어가야 함
    @PostMapping
    @Operation(summary = "마켓 아이템 생성", description = "마켓 아이템을 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "마켓 아이템 생성 성공")
    })
    public ResponseEntity<MarketItemResponseDto> createMarketItem(@RequestBody MarketItemRequestDto requestDto) {

        MarketItemResponseDto newItem = marketItemService.createMarketItem(requestDto);

        return ResponseEntity.status(CREATED).body(newItem);
    }

    @GetMapping
    @Operation(summary = "마켓 아이템 조회", description = "마켓의 모든 아이템을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "마켓 아이템 조회 성공, 아이템이 없는 경우 빈 리스트 반환")
    })
    public ResponseEntity<List<MarketItemResponseDto>> findMarketItemList() {

        List<MarketItemResponseDto> marketItemList = marketItemService.findMarketItemList();

        return ResponseEntity.status(OK).body(marketItemList);
    }

    @PutMapping("/{itemId}")
    @Operation(summary = "마켓 아이템 수정", description = "마켓 아이템을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "아이템이 정상 수정되었습니다."),
            @ApiResponse(responseCode = "404", description = "아이템을 찾을 수 없습니다.")
    })
    public ResponseEntity<MarketItemResponseDto> updateMarketItem(
            @PathVariable Long itemId,
            @RequestBody MarketItemRequestDto requestDto) {

        try {
            MarketItemResponseDto updatedMarketItem = marketItemService.updateMarketItem(itemId, requestDto);
            return ResponseEntity.status(OK).body(updatedMarketItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{itemId}")
    @Operation(summary = "마켓 아이템 삭제", description = "마켓 아이템을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "아이템이 정상 삭제되었습니다."),
            @ApiResponse(responseCode = "404", description = "아이템을 찾을 수 없습니다.")
    })
    public ResponseEntity<Void> deleteMarketItem(@PathVariable Long itemId) {

        try {
            marketItemService.deleteMarketItem(itemId);
            return ResponseEntity.status(NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
}

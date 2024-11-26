package com.ohgiraffers.hellocat.market.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "마켓 룸 거래 API", description = "마켓의 룸 거래 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/market/room")
@RequiredArgsConstructor
public class MarketRoomController {
}

package com.ohgiraffers.hellocat.quest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저 퀘스트 API", description = "유저 퀘스트 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/quest")
@RequiredArgsConstructor
public class UserQuestController {
}


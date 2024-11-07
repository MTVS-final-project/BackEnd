package com.ohgiraffers.hellocat.notice.controller;

import com.ohgiraffers.hellocat.notice.dto.NoticeRequestDto;
import com.ohgiraffers.hellocat.notice.dto.NoticeResponseDto;
import com.ohgiraffers.hellocat.notice.service.NoticeService;
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

@Tag(name = "공지/이벤트 API", description = "공지 및 이벤트 관련 API")
@Slf4j
@RestController
@RequestMapping("/admin/api/v1/notice")
@RequiredArgsConstructor
public class NoticeAdminController {

    private final NoticeService noticeService;

    @PostMapping
    @Operation(summary = "공지 생성", description = "관리자가 공지를 생성합니다.")
    @ApiResponse(responseCode = "201", description = "공지가 정상 생성되었습니다.")
    public ResponseEntity<NoticeResponseDto> createNotice(@RequestBody NoticeRequestDto requestDto) {

        NoticeResponseDto savedNotice = noticeService.createNotice(requestDto);

        return ResponseEntity.status(201).body(savedNotice);
    }
}

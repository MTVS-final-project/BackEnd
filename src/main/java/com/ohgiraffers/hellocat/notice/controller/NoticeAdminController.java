package com.ohgiraffers.hellocat.notice.controller;

import com.ohgiraffers.hellocat.notice.dto.NoticeRequestDto;
import com.ohgiraffers.hellocat.notice.dto.NoticeResponseDto;
import com.ohgiraffers.hellocat.notice.service.NoticeService;
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

        return ResponseEntity.status(CREATED).body(savedNotice);
    }

    @PutMapping("/{noticeId}")
    @Operation(summary = "공지 수정", description = "관리자가 공지를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "공지가 정상 수정되었습니다."),
            @ApiResponse(responseCode = "404", description = "공지를 찾을 수 없습니다.")
    })
    public ResponseEntity<NoticeResponseDto> updateNotice(@PathVariable Long noticeId,
                                                          @RequestBody NoticeRequestDto requestDto) {

        try {
            NoticeResponseDto updatedNotice = noticeService.updateNotice(noticeId, requestDto);
            return ResponseEntity.status(OK).body(updatedNotice);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{noticeId}")
    @Operation(summary = "공지 삭제", description = "관리자가 공지를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "공지가 정상적으로 삭제되었습니다."),
            @ApiResponse(responseCode = "404", description = "공지를 찾을 수 없습니다.")
    })
    public ResponseEntity<?> deleteNotice(@PathVariable Long noticeId) {

        try {
            noticeService.deleteNotice(noticeId);
            return ResponseEntity.status(NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
}

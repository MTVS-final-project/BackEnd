package com.ohgiraffers.hellocat.notice.service;

import com.ohgiraffers.hellocat.notice.dto.NoticeRequestDto;
import com.ohgiraffers.hellocat.notice.dto.NoticeResponseDto;
import com.ohgiraffers.hellocat.notice.entity.Notice;
import com.ohgiraffers.hellocat.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public List<NoticeResponseDto> findAllNotice() {

        List<Notice> noticeList = noticeRepository.findAll();

        return noticeList
                .stream()
                .map(NoticeResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NoticeResponseDto findNoticeById(Long id) {

        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("공지를 찾을 수 없습니다. noticeId: {}", id);
                    return new IllegalArgumentException("공지를 찾을 수 없습니다.");
                });

        return new NoticeResponseDto(notice);
    }

    public NoticeResponseDto createNotice(NoticeRequestDto requestDto) {

        Notice notice = Notice.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .category(requestDto.getCategory())
                .build();

        Notice savedNotice = noticeRepository.save(notice);

        return new NoticeResponseDto(savedNotice);
    }

    public NoticeResponseDto updateNotice(Long noticeId, NoticeRequestDto requestDto) {

        Notice foundNotice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> {
                    log.error("공지를 찾을 수 없습니다. noticeId: {}", noticeId);
                    return new IllegalArgumentException("공지를 찾을 수 없습니다.");
                });

        Notice updatedNotice = foundNotice.update(requestDto);

        return new NoticeResponseDto(updatedNotice);
    }
}

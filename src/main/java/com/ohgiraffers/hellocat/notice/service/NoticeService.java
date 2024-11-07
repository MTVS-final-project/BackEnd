package com.ohgiraffers.hellocat.notice.service;

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
}

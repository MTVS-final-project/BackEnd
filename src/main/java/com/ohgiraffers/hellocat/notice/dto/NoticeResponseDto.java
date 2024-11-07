package com.ohgiraffers.hellocat.notice.dto;

import com.ohgiraffers.hellocat.notice.entity.Notice;
import com.ohgiraffers.hellocat.notice.enums.NoticeCategory;
import lombok.Builder;
import lombok.Data;

@Data
public class NoticeResponseDto {

    private Long id;
    private String title;
    private String content;
    private NoticeCategory category;

    @Builder
    public NoticeResponseDto(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.category = notice.getCategory();
    }
}

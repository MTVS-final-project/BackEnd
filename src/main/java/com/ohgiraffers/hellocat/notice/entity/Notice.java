package com.ohgiraffers.hellocat.notice.entity;

import com.ohgiraffers.hellocat.notice.dto.NoticeRequestDto;
import com.ohgiraffers.hellocat.notice.enums.NoticeCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "공지 제목은 필수입니다.")
    private String title;

    @NotBlank(message = "공지 내용은 필수입니다.")
    private String content;

    @NotNull(message = "카테고리는 필수입니다.")
    @Enumerated(EnumType.STRING)
    private NoticeCategory category;

    @Builder
    public Notice(String title, String content, NoticeCategory category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Notice update(NoticeRequestDto requestDto) {
        title = requestDto.getTitle();
        content = requestDto.getContent();
        category = requestDto.getCategory();
        return this;
    }
}

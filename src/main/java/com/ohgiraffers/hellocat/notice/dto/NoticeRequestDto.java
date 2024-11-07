package com.ohgiraffers.hellocat.notice.dto;

import com.ohgiraffers.hellocat.notice.enums.NoticeCategory;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequestDto {

    @NotNull(message = "공지 제목은 필수입니다.")
    private String title;

    @NotNull(message = "공지 내용은 필수입니다.")
    private String content;

    @NotNull(message = "공지 카테고리는 필수입니다.")
    private NoticeCategory category;
}

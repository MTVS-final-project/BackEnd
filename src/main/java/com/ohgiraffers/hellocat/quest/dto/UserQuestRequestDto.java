package com.ohgiraffers.hellocat.quest.dto;

import com.ohgiraffers.hellocat.quest.enums.QuestStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserQuestRequestDto {

    @NotNull(message = "생성 유저 ID는 필수입니다.")
    private Long userId;

    @NotBlank(message = "퀘스트 제목은 필수입니다.")
    private String title;

    @NotBlank(message = "퀘스트 내용은 필수입니다.")
    private String description;

    @NotNull(message = "보상 아이템은 필수입니다.")
    private Long reward;

    @NotNull(message = "퀘스트 수행 여부는 필수입니다.")
    private QuestStatus questStatus;
}

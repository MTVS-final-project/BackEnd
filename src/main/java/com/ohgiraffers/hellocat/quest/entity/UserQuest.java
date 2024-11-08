package com.ohgiraffers.hellocat.quest.entity;

import com.ohgiraffers.hellocat.quest.dto.UserQuestRequestDto;
import com.ohgiraffers.hellocat.quest.enums.QuestStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Entity
@Getter
@NoArgsConstructor
public class UserQuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "생성 유저 ID는 필수입니다.")
    private Long userId;

    @NotBlank(message = "퀘스트 제목은 필수입니다.")
    private String title;

    @NotBlank(message = "퀘스트 내용은 필수입니다.")
    private String description;

    @NotNull(message = "보상 아이템은 필수입니다.")
    // Todo: 해시맵으로 교체 예정
    private Long reward;

    // Todo: 수행중인 상태도 표시 해야하나?
    @NotNull(message = "퀘스트 수행 여부는 필수입니다.")
    @Enumerated(EnumType.STRING)
    private QuestStatus questStatus;

    @Builder
    public UserQuest(Long userId, String title, String description, Long reward, QuestStatus questStatus) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.reward = reward;
        this.questStatus = questStatus;
    }

    public UserQuest update(UserQuestRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.description = requestDto.getDescription();
        this.reward = requestDto.getReward();
        this.questStatus = requestDto.getQuestStatus();
        return this;
    }
}

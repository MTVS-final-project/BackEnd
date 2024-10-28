package com.ohgiraffers.hellocat.quest.dto;

import com.ohgiraffers.hellocat.quest.entity.UserQuest;
import com.ohgiraffers.hellocat.quest.enums.QuestStatus;
import lombok.Builder;
import lombok.Data;

@Data
public class UserQuestResponseDto {

    private Long id;
    private Long userId;
    private String title;
    private String description;
    private Long reward;
    private QuestStatus questStatus;

    @Builder
    public UserQuestResponseDto(UserQuest userQuest) {
        this.id = userQuest.getId();
        this.userId = userQuest.getUserId();
        this.title = userQuest.getTitle();
        this.description = userQuest.getDescription();
        this.reward = userQuest.getReward();
        this.questStatus = userQuest.getQuestStatus();
    }
}

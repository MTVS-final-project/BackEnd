package com.ohgiraffers.hellocat.quest.dto;

import com.ohgiraffers.hellocat.quest.entity.UserQuest;
import lombok.Builder;
import lombok.Data;

@Data
public class UserQuestResponseDto {

    private Long id;
    private Long userId;
    private String title;
    private String description;
    private Long reward;
    private Boolean complete;

    @Builder
    public UserQuestResponseDto(UserQuest userQuest) {
        this.id = userQuest.getUserId();
        this.userId = userQuest.getUserId();
        this.title = userQuest.getTitle();
        this.description = userQuest.getDescription();
        this.reward = userQuest.getReward();
        this.complete = userQuest.getComplete();
    }
}

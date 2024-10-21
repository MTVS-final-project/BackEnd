package com.ohgiraffers.hellocat.character.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterUpdateResponseDto {

    private Long skin;
    private Long hair;
    private Long eye;
    private Long mouth;
    private Long leftArm;
    private Long rightArm;
    private Long pants;
    private Long leftLeg;
    private Long rightLeg;
    private Long leftShoe;
    private Long rightShoe;

    @Builder
    public CharacterUpdateResponseDto(Long skin, Long hair, Long eye, Long mouth, Long leftArm, Long rightArm, Long pants, Long leftLeg, Long rightLeg, Long leftShoe, Long rightShoe) {
        this.skin = skin;
        this.hair = hair;
        this.eye = eye;
        this.mouth = mouth;
        this.leftArm = leftArm;
        this.rightArm = rightArm;
        this.pants = pants;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
        this.leftShoe = leftShoe;
        this.rightShoe = rightShoe;
    }
}

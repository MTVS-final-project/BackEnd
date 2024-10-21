package com.ohgiraffers.hellocat.character.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

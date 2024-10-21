package com.ohgiraffers.hellocat.character.entity;

import com.ohgiraffers.hellocat.character.dto.CharacterUpdateRequestDto;
import com.ohgiraffers.hellocat.character.dto.CharacterUpdateResponseDto;
import com.ohgiraffers.hellocat.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Character {

    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

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

    public Character(User user) {
        this.user = user;
    }

    public void update(CharacterUpdateRequestDto requestDto) {
        this.skin = requestDto.getSkin();
        this.hair = requestDto.getHair();
        this.eye = requestDto.getEye();
        this.mouth = requestDto.getMouth();
        this.leftArm = requestDto.getLeftArm();
        this.rightArm = requestDto.getRightArm();
        this.pants = requestDto.getPants();
        this.leftLeg = requestDto.getLeftLeg();
        this.rightLeg = requestDto.getRightLeg();
        this.leftShoe = requestDto.getLeftShoe();
        this.rightShoe = requestDto.getRightShoe();
    }

}

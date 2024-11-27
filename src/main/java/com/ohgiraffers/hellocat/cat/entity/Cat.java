package com.ohgiraffers.hellocat.cat.entity;

import com.ohgiraffers.hellocat.cat.dto.CatRequestDto;
import com.ohgiraffers.hellocat.cat.dto.CatUpdateRequestDto;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "cat")
@Getter
@NoArgsConstructor
public class Cat {

    @Id
    private String id;

    @NotNull(message = "고양이 주인의 아이디는 필수입니다.")
    private Long ownerId;

    @NotEmpty(message = "고양이의 성격은 필수입니다.")
    private String personality;

    @NotNull(message = "고양이의 나이는 필수입니다.")
    private Double age;

    @NotNull(message = "고양이의 생일은 필수입니다.")
    private LocalDateTime birth;

    @NotNull(message = "고양이의 몸무게는 필수입니다.")
    private Double weight;

    @NotNull(message = "고양이의 성별은 필수입니다.")
    private Boolean male;

    @NotNull(message = "고양이의 졸음 수치는 필수입니다.")
    private Double sleepy;

    @NotNull(message = "고양이의 배고픔 수치는 필수입니다.")
    private Double hunger;

    @NotNull(message = "고양이의 친밀도는 필수입니다.")
    private Double friendly;

    @NotNull(message = "고양이의 기분은 필수입니다.")
    private Double mood;

    @NotNull(message = "고양이의 신진대사는 필수입니다.")
    private Double metabolism;

    @NotNull(message = "고양이의 이동 간격은 필수입니다.")
    private Double moveTerm;

    @NotNull(message = "고양이의 이동 범위는 필수입니다.")
    private Double moveRange;

    @NotNull(message = "고양이의 배설 욕구는 필수입니다.")
    private Double discharge;

    @NotNull(message = "고양이의 속도는 필수입니다.")
    private Double speed;

    @NotNull(message = "고양이의 식사 속도는 필수입니다.")
    private Double eatSpeed;

    @NotNull(message = "고양이의 인덱스는 필수입니다.")
    private Double catIndex;

    public Cat(CatRequestDto requestDto) {
        this.ownerId = requestDto.getOwnerId();
        this.personality = requestDto.getPersonality();
        this.age = requestDto.getAge();
        this.birth = LocalDateTime.now();
        this.weight = requestDto.getWeight();
        this.male = requestDto.getMale();
        this.sleepy = requestDto.getSleepy();
        this.hunger = requestDto.getHunger();
        this.friendly = requestDto.getFriendly();
        this.mood = requestDto.getMood();
        this.metabolism = requestDto.getMetabolism();
        this.moveTerm = requestDto.getMoveTerm();
        this.moveRange = requestDto.getMoveRange();
        this.discharge = requestDto.getDischarge();
        this.speed = requestDto.getSpeed();
        this.eatSpeed = requestDto.getEatSpeed();
        this.catIndex = requestDto.getCatIndex();
    }

    public Cat update(CatUpdateRequestDto requestDto) {
        this.personality = requestDto.getPersonality();
        this.age = requestDto.getAge();
        this.weight = requestDto.getWeight();
        this.sleepy = requestDto.getSleepy();
        this.hunger = requestDto.getHunger();
        this.friendly = requestDto.getFriendly();
        this.mood = requestDto.getMood();
        this.metabolism = requestDto.getMetabolism();
        this.moveTerm = requestDto.getMoveTerm();
        this.moveRange = requestDto.getMoveRange();
        this.discharge = requestDto.getDischarge();
        this.speed = requestDto.getSpeed();
        this.eatSpeed = requestDto.getEatSpeed();
        this.catIndex = requestDto.getCatIndex();
        return this;
    }
}

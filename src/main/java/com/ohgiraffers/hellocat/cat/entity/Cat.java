package com.ohgiraffers.hellocat.cat.entity;

import com.ohgiraffers.hellocat.cat.dto.CatRequestDto;
import com.ohgiraffers.hellocat.cat.dto.CatUpdateRequestDto;
import jakarta.persistence.Id;
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

    private Long ownerId;

    private String personality;

    private Double age;

    private LocalDateTime birth;

    private Double weight;

    private Boolean male;

    private Double sleepy;

    private Double hunger;

    private Double friendly;

    private Double mood;

    private Double metabolism;

    private Double moveTerm;

    private Double moveRange;

    private Double discharge;

    private Double speed;

    private Double eatSpeed;

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

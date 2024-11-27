package com.ohgiraffers.hellocat.cat.dto;

import com.ohgiraffers.hellocat.cat.entity.Cat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatResponseDto {

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

    public CatResponseDto(Cat cat) {
        this.id = cat.getId();
        this.ownerId = cat.getOwnerId();
        this.personality = cat.getPersonality();
        this.age = cat.getAge();
        this.birth = cat.getBirth();
        this.weight = cat.getWeight();
        this.male = cat.getMale();
        this.sleepy = cat.getSleepy();
        this.hunger = cat.getHunger();
        this.friendly = cat.getFriendly();
        this.mood = cat.getMood();
        this.metabolism = cat.getMetabolism();
        this.moveTerm = cat.getMoveTerm();
        this.moveRange = cat.getMoveRange();
        this.discharge = cat.getDischarge();
        this.speed = cat.getSpeed();
        this.eatSpeed = cat.getEatSpeed();
        this.catIndex = cat.getCatIndex();
    }
}

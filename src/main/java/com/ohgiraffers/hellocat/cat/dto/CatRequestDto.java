package com.ohgiraffers.hellocat.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatRequestDto {

    private Long ownerId;

    private String personality;

    private Double age;

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
}

package com.ohgiraffers.hellocat.cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatUpdateRequestDto {

    private String personality;

    private Double age;

    private Double weight;

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

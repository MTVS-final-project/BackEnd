package com.ohgiraffers.hellocat.cat.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatUpdateRequestDto {

    @NotEmpty(message = "고양이의 성격은 필수입니다.")
    private String personality;

    @NotNull(message = "고양이의 나이는 필수입니다.")
    private Double age;

    @NotNull(message = "고양이의 몸무게는 필수입니다.")
    private Double weight;

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
}

package com.ohgiraffers.hellocat.room.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureRequestDto {

    @Positive(message = "가구의 사이즈는 양수입니다.")
    private Long size;

    @JsonProperty("spriteNum")
    @Positive(message = "가구의 sprite 번호는 양수입니다.")
    private Long spriteNumber;

    @JsonProperty("xpos")
    @NotNull(message = "가구의 X 위치는 필수입니다.")
    private double positionX;

    @JsonProperty("ypos")
    @NotNull(message = "가구의 Y 위치는 필수입니다.")
    private double positionY;

    @JsonProperty("rotY")
    @NotNull(message = "가구의 Y 회전값은 필수입니다.")
    private double rotationY;
}

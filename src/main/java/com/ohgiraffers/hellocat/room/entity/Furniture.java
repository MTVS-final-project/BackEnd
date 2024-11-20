package com.ohgiraffers.hellocat.room.entity;

import com.ohgiraffers.hellocat.room.dto.FurnitureRequestDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Furniture {

    @Positive(message = "가구의 사이즈는 양수입니다.")
    private Long size;

    @Positive(message = "가구의 sprite 번호는 양수입니다.")
    private Long spriteNumber;

    @NotNull(message = "가구의 X 위치는 필수입니다.")
    private double positionX;

    @NotNull(message = "가구의 Y 위치는 필수입니다.")
    private double positionY;

    @NotNull(message = "가구의 Y 회전값은 필수입니다.")
    private double rotationY;

    public Furniture(FurnitureRequestDto requestDto) {
        this.size = requestDto.getSize();
        this.spriteNumber = requestDto.getSpriteNumber();
        this.positionX = requestDto.getPositionX();
        this.positionY = requestDto.getPositionY();
        this.rotationY = requestDto.getRotationY();
    }
}

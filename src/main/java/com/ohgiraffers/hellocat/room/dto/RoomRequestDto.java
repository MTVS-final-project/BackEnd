package com.ohgiraffers.hellocat.room.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequestDto {

    @JsonProperty("makerId")
    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long ownerId;
    private List<FurnitureRequestDto> furnitureList;
}

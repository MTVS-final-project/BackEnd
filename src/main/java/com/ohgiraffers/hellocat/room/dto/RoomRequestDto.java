package com.ohgiraffers.hellocat.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequestDto {

    private Long makerId;
    private List<FurnitureRequestDto> furnitureList;
}

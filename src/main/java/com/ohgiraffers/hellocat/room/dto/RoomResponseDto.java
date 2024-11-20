package com.ohgiraffers.hellocat.room.dto;

import com.ohgiraffers.hellocat.room.entity.Furniture;
import com.ohgiraffers.hellocat.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDto {

    private String id;
    private Long makerId;
    private List<Furniture> furnitureList;

    public RoomResponseDto(Room room) {
        this.id = room.getId();
        this.makerId = room.getMakerId();
        this.furnitureList = room.getFurnitureList();
    }
}

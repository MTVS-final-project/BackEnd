package com.ohgiraffers.hellocat.room.dto;

import com.ohgiraffers.hellocat.room.entity.Furniture;
import com.ohgiraffers.hellocat.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDto {

    private String id;
    private Long ownerId;
    private List<Furniture> furnitureList;
    private LocalDateTime createdAt;

    public RoomResponseDto(Room room) {
        this.id = room.getId();
        this.ownerId = room.getOwnerId();
        this.furnitureList = room.getFurnitureList();
        this.createdAt = room.getCreatedAt();
    }
}

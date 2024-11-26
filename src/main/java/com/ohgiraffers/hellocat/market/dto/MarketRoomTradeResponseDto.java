package com.ohgiraffers.hellocat.market.dto;

import com.ohgiraffers.hellocat.room.entity.Furniture;
import com.ohgiraffers.hellocat.room.entity.Room;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MarketRoomTradeResponseDto {

    private String id;
    private Long ownerId;
    private List<Furniture> furnitureList;
    private LocalDateTime createdAt;

    public MarketRoomTradeResponseDto(Room room) {
        this.id = room.getId();
        this.ownerId = room.getOwnerId();
        this.furnitureList = room.getFurnitureList();
        this.createdAt = room.getCreatedAt();
    }
}

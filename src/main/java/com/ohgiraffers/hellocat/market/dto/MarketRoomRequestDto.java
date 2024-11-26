package com.ohgiraffers.hellocat.market.dto;

import com.ohgiraffers.hellocat.room.dto.RoomResponseDto;
import com.ohgiraffers.hellocat.room.entity.Furniture;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MarketRoomRequestDto {

    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long makerId;

    @NotNull(message = "가격은 필수입니다.")
    private Long price;

    @NotNull(message = "가구 리스트는 필수입니다.")
    private List<Furniture> furnitureList;

    public MarketRoomRequestDto(RoomResponseDto room, Long price) {
        this.makerId = room.getMakerId();
        this.price = price;
        this.furnitureList = room.getFurnitureList();
    }
}

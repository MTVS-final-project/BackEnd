package com.ohgiraffers.hellocat.market.dto;

import com.ohgiraffers.hellocat.market.entity.MarketRoom;
import com.ohgiraffers.hellocat.room.entity.Furniture;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketRoomResponseDto {

    @NotNull(message = "방 아이디는 필수입니다.")
    private Long id;

    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long makerId;

    @NotNull(message = "가격은 필수입니다.")
    private Long price;

    @NotNull(message = "가구 리스트는 필수입니다.")
    private List<Furniture> furnitureList;

    @NotNull(message = "등록 시간은 필수입니다.")
    private LocalDateTime uploadedAt;

    public MarketRoomResponseDto(MarketRoom savedMarketRoom) {
        this.id = savedMarketRoom.getId();
        this.makerId = savedMarketRoom.getMakerId();
        this.price = savedMarketRoom.getPrice();
        this.furnitureList = savedMarketRoom.getFurnitureList();
        this.uploadedAt = savedMarketRoom.getUploadedAt();
    }
}

package com.ohgiraffers.hellocat.market.entity;

import com.ohgiraffers.hellocat.market.dto.MarketRoomRequestDto;
import com.ohgiraffers.hellocat.room.entity.Furniture;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "market_room")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarketRoom {

    @Id
    private Long id;

    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long makerId;

    @NotNull(message = "가격은 필수입니다.")
    private Long price;

    private List<Furniture> furnitureList = new ArrayList<>();

    private LocalDateTime uploadedAt;

    public MarketRoom(MarketRoomRequestDto requestDto) {
        this.makerId = requestDto.getMakerId();
        this.price = requestDto.getPrice();
        this.furnitureList = requestDto.getFurnitureList();
        this.uploadedAt = LocalDateTime.now();
    }
}

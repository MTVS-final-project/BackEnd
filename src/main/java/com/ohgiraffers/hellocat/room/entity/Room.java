package com.ohgiraffers.hellocat.room.entity;

import com.ohgiraffers.hellocat.room.dto.RoomRequestDto;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "room")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    private String id;

    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long makerId;

    private List<Furniture> furnitureList = new ArrayList<>();

    private LocalDateTime createdAt;

    public Room(RoomRequestDto requestDto, List<Furniture> furnitureList) {
        this.makerId = requestDto.getMakerId();
        this.furnitureList = furnitureList;
        this.createdAt = LocalDateTime.now();
    }
}

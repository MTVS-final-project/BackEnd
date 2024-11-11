package com.ohgiraffers.hellocat.room.dto;

import com.ohgiraffers.hellocat.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDto {

    private String id;
    private Long makerId;

    public RoomResponseDto(Room room) {
        this.id = room.getId();
        this.makerId = room.getMakerId();
    }
}

package com.ohgiraffers.hellocat.room.entity;

import com.ohgiraffers.hellocat.room.dto.RoomRequestDto;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "room")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    private String id;

    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long makerId;

    public Room(RoomRequestDto requestDto) {
        this.makerId = requestDto.getMakerId();
    }
}

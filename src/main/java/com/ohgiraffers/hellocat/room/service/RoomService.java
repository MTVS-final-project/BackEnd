package com.ohgiraffers.hellocat.room.service;

import com.ohgiraffers.hellocat.room.dto.RoomRequestDto;
import com.ohgiraffers.hellocat.room.dto.RoomResponseDto;
import com.ohgiraffers.hellocat.room.entity.Room;
import com.ohgiraffers.hellocat.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomResponseDto saveRoom(RoomRequestDto roomRequestDto) {

        Room room = new Room(roomRequestDto);

        roomRepository.save(room);

        return new RoomResponseDto(room);
    }
}

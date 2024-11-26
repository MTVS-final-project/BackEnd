package com.ohgiraffers.hellocat.room.service;

import com.ohgiraffers.hellocat.room.dto.RoomRequestDto;
import com.ohgiraffers.hellocat.room.dto.RoomResponseDto;
import com.ohgiraffers.hellocat.room.entity.Furniture;
import com.ohgiraffers.hellocat.room.entity.Room;
import com.ohgiraffers.hellocat.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomResponseDto saveRoom(RoomRequestDto requestDto) {

        List<Furniture> furnitureList = requestDto.getFurnitureList().stream()
                .map(Furniture::new)
                .toList();

        Room room = new Room(requestDto, furnitureList);

        roomRepository.save(room);

        return new RoomResponseDto(room);
    }

    public RoomResponseDto findRoomById(String id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 룸 ID 입니다."));

        return new RoomResponseDto(room);
    }

    public List<RoomResponseDto> findRoomByMakerId(Long ownerId) {
        return roomRepository.findAllByOwnerId(ownerId).stream()
                .map(RoomResponseDto::new)
                .toList();
    }
}

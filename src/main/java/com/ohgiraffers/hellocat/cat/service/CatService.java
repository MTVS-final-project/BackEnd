package com.ohgiraffers.hellocat.cat.service;

import com.ohgiraffers.hellocat.cat.dto.CatRequestDto;
import com.ohgiraffers.hellocat.cat.dto.CatResponseDto;
import com.ohgiraffers.hellocat.cat.dto.CatUpdateRequestDto;
import com.ohgiraffers.hellocat.cat.entity.Cat;
import com.ohgiraffers.hellocat.cat.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    public CatResponseDto saveCat(CatRequestDto requestDto) {

        Cat cat = new Cat(requestDto);

        Cat savedCat = catRepository.save(cat);

        return new CatResponseDto(savedCat);
    }

    public CatResponseDto findCatByOwnerId(Long ownerId) {

        Cat foundCat = catRepository.findCatByOwnerId(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("고양이를 찾을 수 없습니다."));

        return new CatResponseDto(foundCat);
    }

    public CatResponseDto updateCatInfo(CatUpdateRequestDto requestDto, String catId) {

        Cat foundCat = catRepository.findById(catId)
                .orElseThrow(() -> new IllegalArgumentException("고양이를 찾을 수 없습니다."));

        Cat updatedCat = foundCat.update(requestDto);

        catRepository.save(updatedCat);

        return new CatResponseDto(updatedCat);
    }
}

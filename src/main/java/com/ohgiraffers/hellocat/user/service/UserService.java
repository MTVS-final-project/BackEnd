package com.ohgiraffers.hellocat.user.service;

import com.ohgiraffers.hellocat.user.dto.UserCreateResponseDto;
import com.ohgiraffers.hellocat.user.dto.UserFindResponseDto;
import com.ohgiraffers.hellocat.user.entity.User;
import com.ohgiraffers.hellocat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserFindResponseDto findById(Long userId) {

        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        return UserFindResponseDto.builder()
                .id(foundUser.getId())
                .character(foundUser.getCharacter())
                .build();
    }

    public UserCreateResponseDto createUser(User user) {

        User savedUser = userRepository.save(user);

        return new UserCreateResponseDto(savedUser);
    }
}

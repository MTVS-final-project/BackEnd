package com.ohgiraffers.hellocat.user.service;

import com.ohgiraffers.hellocat.user.dto.UserCreateResponseDto;
import com.ohgiraffers.hellocat.user.dto.UserFindResponseDto;
import com.ohgiraffers.hellocat.user.entity.User;
import com.ohgiraffers.hellocat.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        userRepository.save(user);

        return UserCreateResponseDto.builder()
                .id(user.getId())
                .character(user.getCharacter())
                .build();
    }
}

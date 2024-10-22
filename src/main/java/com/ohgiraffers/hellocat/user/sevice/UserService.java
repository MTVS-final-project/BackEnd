package com.ohgiraffers.hellocat.user.sevice;

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

    public User findById(Long userId) {

        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        return foundUser;
    }
}

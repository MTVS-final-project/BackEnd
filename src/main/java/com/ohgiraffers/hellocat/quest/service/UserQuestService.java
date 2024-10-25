package com.ohgiraffers.hellocat.quest.service;

import com.ohgiraffers.hellocat.quest.dto.UserQuestResponseDto;
import com.ohgiraffers.hellocat.quest.entity.UserQuest;
import com.ohgiraffers.hellocat.quest.repository.UserQuestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserQuestService {

    private final UserQuestRepository userQuestRepository;

    public List<UserQuestResponseDto> findUserQuestList() {

        List<UserQuest> questList = userQuestRepository.findAll();

        return  questList
                .stream()
                .map(UserQuestResponseDto::new)
                .collect(Collectors.toList());
    }
}

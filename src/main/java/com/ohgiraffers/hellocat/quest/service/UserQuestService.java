package com.ohgiraffers.hellocat.quest.service;

import com.ohgiraffers.hellocat.quest.dto.UserQuestRequestDto;
import com.ohgiraffers.hellocat.quest.dto.UserQuestResponseDto;
import com.ohgiraffers.hellocat.quest.entity.UserQuest;
import com.ohgiraffers.hellocat.quest.enums.QuestStatus;
import com.ohgiraffers.hellocat.quest.repository.UserQuestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.ohgiraffers.hellocat.quest.enums.QuestStatus.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserQuestService {

    private final UserQuestRepository userQuestRepository;

    @Transactional(readOnly = true)
    public List<UserQuestResponseDto> findUserQuestList() {

        List<UserQuest> questList = userQuestRepository.findAll();

        return  questList
                .stream()
                .map(UserQuestResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UserQuestResponseDto> findUserQuestByUserId(Long userId) {

        List<UserQuest> questList = userQuestRepository.findAllByUserId(userId);

        return  questList
                .stream()
                .map(UserQuestResponseDto::new)
                .collect(Collectors.toList());
    }

    public UserQuestResponseDto createUserQuest(UserQuestRequestDto requestDto) {

        UserQuest userQuest = UserQuest.builder()
                .userId(requestDto.getUserId())
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .reward(requestDto.getReward())
                .questStatus(requestDto.getQuestStatus())
                .build();

        UserQuest savedQuest = userQuestRepository.save(userQuest);

        return new UserQuestResponseDto(savedQuest);
    }

    public UserQuestResponseDto updateUserQuest(Long questId, Long userId, UserQuestRequestDto requestDto) {

        UserQuest userQuest = userQuestRepository.findById(questId)
                .orElseThrow(() ->
                        new IllegalArgumentException("퀘스트를 찾을 수 없습니다."));

        if (!userQuest.getUserId().equals(userId)) {
            throw new SecurityException("해당 퀘스트를 수정할 권한이 없습니다.");
        }

        if (userQuest.getQuestStatus().equals(진행중) || userQuest.getQuestStatus().equals(완료)) {
            throw new IllegalStateException("진행중이거나 완료된 퀘스트는 수정이 불가능합니다.");
        }

        UserQuest updatedQuest = userQuest.update(requestDto);

        return new UserQuestResponseDto(updatedQuest);
    }

    public void deleteUserQuest(Long questId, Long userId) {

        UserQuest foundQuest = userQuestRepository.findById(questId)
                .orElseThrow(() ->
                        new IllegalArgumentException("퀘스트를 찾을 수 없습니다."));

        if (!foundQuest.getUserId().equals(userId)) {
            throw new SecurityException("해당 퀘스트를 삭제할 권한이 없습니다.");
        }

        if (foundQuest.getQuestStatus().equals(진행중) || foundQuest.getQuestStatus().equals(완료)) {
            throw new IllegalStateException("진행중이거나 완료된 퀘스트는 삭제가 불가능합니다.");
        }

        userQuestRepository.delete(foundQuest);
    }
}

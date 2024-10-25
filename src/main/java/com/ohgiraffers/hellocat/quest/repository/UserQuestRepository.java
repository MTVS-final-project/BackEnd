package com.ohgiraffers.hellocat.quest.repository;

import com.ohgiraffers.hellocat.quest.entity.UserQuest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuestRepository extends JpaRepository<UserQuest, Long> {

    List<UserQuest> findAllByUserId(Long userId);
}

package com.ohgiraffers.hellocat.quest.repository;

import com.ohgiraffers.hellocat.quest.entity.UserQuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestRepository extends JpaRepository<UserQuest, Long> {
}

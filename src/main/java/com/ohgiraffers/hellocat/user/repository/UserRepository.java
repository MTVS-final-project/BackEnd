package com.ohgiraffers.hellocat.user.repository;

import com.ohgiraffers.hellocat.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

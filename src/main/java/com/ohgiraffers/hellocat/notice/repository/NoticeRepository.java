package com.ohgiraffers.hellocat.notice.repository;

import com.ohgiraffers.hellocat.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}

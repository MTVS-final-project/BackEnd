package com.ohgiraffers.hellocat.item.entity;

import com.ohgiraffers.hellocat.item.dto.ItemRequestDto;
import com.ohgiraffers.hellocat.market.enums.MarketItemCategory;
import com.ohgiraffers.hellocat.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull(message = "보유 유저 아이디는 필수입니다.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long makerId;

    @NotBlank(message = "아이템 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "아이템 설명은 필수입니다.")
    private String description;

    @NotNull(message = "아이템 개수는 필수입니다.")
    private Long count;

    @NotNull(message = "아이템 카테고리는 필수입니다.")
    @Enumerated(EnumType.STRING)
    private MarketItemCategory category;

    public Item(ItemRequestDto requestDto) {
        this.userId = requestDto.getUserId();
        this.makerId = requestDto.getMakerId();
        this.name = requestDto.getName();
        this.description = requestDto.getDescription();
        this.count = requestDto.getCount();
        this.category = requestDto.getCategory();
    }

    public void addItem(Long count) {
        this.count += count;
    }

    public void removeItem(Long count) {

        if (this.count < count) {
            throw new IllegalArgumentException("보유 개수가 모자랍니다.");
        }

        this.count -= count;
    }
}

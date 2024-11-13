package com.ohgiraffers.hellocat.item.dto;

import com.ohgiraffers.hellocat.item.entity.Item;
import com.ohgiraffers.hellocat.market.enums.MarketItemCategory;
import com.ohgiraffers.hellocat.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {

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

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.userId = item.getUserId();
        this.makerId = item.getMakerId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.count = item.getCount();
        this.category = item.getCategory();
    }
}

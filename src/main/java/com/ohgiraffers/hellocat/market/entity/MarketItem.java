package com.ohgiraffers.hellocat.market.entity;

import com.ohgiraffers.hellocat.market.dto.MarketItemRequestDto;
import com.ohgiraffers.hellocat.market.enums.MarketItemCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarketItem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long makerId;

    @NotBlank(message = "아이템 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "아이템 설명은 필수입니다.")
    private String description;

    @NotNull(message = "아이템 가격은 필수입니다.")
    private Long price;

    @NotNull(message = "아이템 카테고리는 필수입니다.")
    @Enumerated(EnumType.STRING)
    private MarketItemCategory category;

    public MarketItem(MarketItemRequestDto requestDto) {
        this.makerId = requestDto.getMakerId();
        this.name = requestDto.getName();
        this.description = requestDto.getDescription();
        this.price = requestDto.getPrice();
        this.category = requestDto.getCategory();
    }

    public MarketItem update(MarketItemRequestDto requestDto) {
        this.name = requestDto.getName();
        this.description = requestDto.getDescription();
        this.price = requestDto.getPrice();
        this.category = requestDto.getCategory();

        return this;
    }
}

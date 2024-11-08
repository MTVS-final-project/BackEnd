package com.ohgiraffers.hellocat.market.dto;

import com.ohgiraffers.hellocat.market.entity.MarketItem;
import com.ohgiraffers.hellocat.market.enums.MarketItemCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
public class MarketItemTradeResponseDto {

    @NotNull(message = "아이템 아이디는 필수입니다.")
    private Long itemId;

    @NotNull(message = "제작자 아이디는 필수입니다.")
    private Long makerId;

    @NotBlank(message = "아이템 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "아이템 설명은 필수입니다.")
    private String description;

    @NotNull(message = "아이템 카테고리는 필수입니다.")
    @Enumerated(EnumType.STRING)
    private MarketItemCategory category;

    public MarketItemTradeResponseDto(MarketItem marketItem) {
        this.itemId = marketItem.getId();
        this.name = marketItem.getName();
        this.description = marketItem.getDescription();
        this.category = marketItem.getCategory();
    }
}

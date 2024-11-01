package com.ohgiraffers.hellocat.market.dto;

import com.ohgiraffers.hellocat.market.enums.MarketItemCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarketItemRequestDto {

    @NotBlank(message = "아이템 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "아이템 설명은 필수입니다.")
    private String description;

    @NotNull(message = "아이템 가격은 필수입니다.")
    private Long price;

    @NotNull(message = "아이템 카테고리는 필수입니다.")
    private MarketItemCategory category;
}

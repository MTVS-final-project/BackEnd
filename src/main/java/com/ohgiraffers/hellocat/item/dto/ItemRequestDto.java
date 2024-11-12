package com.ohgiraffers.hellocat.item.dto;

import com.ohgiraffers.hellocat.market.enums.MarketItemCategory;
import com.ohgiraffers.hellocat.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDto {

    private User userId;
    private Long makerId;
    private String name;
    private String description;
    private Long count;
    private MarketItemCategory category;
}

package com.ohgiraffers.hellocat.item.dto;

import com.ohgiraffers.hellocat.market.entity.MarketItem;
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

    public ItemRequestDto(MarketItem foundItem, User buyerId) {
        this.userId = buyerId;
        this.makerId = foundItem.getMakerId();
        this.name = foundItem.getName();
        this.description = foundItem.getDescription();
        this.count = 1L;
        // Todo: 개수 로직 추후 변경
        this.category = foundItem.getCategory();
    }
}

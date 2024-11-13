package com.ohgiraffers.hellocat.user.dto;

import com.ohgiraffers.hellocat.character.entity.Character;
import com.ohgiraffers.hellocat.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateResponseDto {

    private Long id;
    private Character character;
    private Long coin;

    @Builder
    public UserCreateResponseDto(User user) {
        this.id = user.getId();
        this.character = user.getCharacter();
        this.coin = user.getCoin();
    }
}

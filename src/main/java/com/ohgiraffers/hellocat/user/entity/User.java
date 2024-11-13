package com.ohgiraffers.hellocat.user.entity;

import com.ohgiraffers.hellocat.character.entity.Character;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_character_id")
    private Character character;

    @NotNull(message = "코인은 필수입니다.")
    private Long coin;

    public void makeCharacter(Character character) {
        this.character = character;
        this.coin = 100L;
    }

    public void addCoin(Long price) {
        this.coin += price;
    }

    public void removeCoin(Long price) {
        
        if (this.coin < price) {
            throw new IllegalArgumentException("코인이 부족합니다.");
        }
        this.coin -= price;
    }
}

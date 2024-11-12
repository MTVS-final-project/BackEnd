package com.ohgiraffers.hellocat.user.entity;

import com.ohgiraffers.hellocat.character.entity.Character;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

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

    @NotNull(message = "생성 시간은 필수입니다.")
    private LocalDateTime registrationDate;

    public void makeCharacter(Character character) {
        this.character = character;
        this.coin = 0L;
        this.registrationDate = LocalDateTime.now();
    }

    public void addCoin(Long price) {
        this.coin += price;
    }

    public void removeCoin(Long price) {
        if (this.coin >= price) {
            this.coin -= price;
        }
    }
}

package com.ohgiraffers.hellocat.user.entity;

import com.ohgiraffers.hellocat.character.entity.Character;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(mappedBy = "user", cascade = ALL, fetch = LAZY)
    private Character character;

    public void createCharacter() {
        this.character = new Character(this);
    }
}

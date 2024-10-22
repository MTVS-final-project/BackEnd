package com.ohgiraffers.hellocat.character.repository;

import com.ohgiraffers.hellocat.character.entity.Character;
import com.ohgiraffers.hellocat.user.entity.User;
import com.ohgiraffers.hellocat.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CharacterRepositoryTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 ID로 캐릭터 조회 테스트")
    void testFindByUserId() {

        User user = new User();
        Character character = new Character(user);
        user.createCharacter(character);

        characterRepository.save(character);
        userRepository.save(user);

        Optional<Character> foundCharacter = characterRepository.findByUserId(user.getId());

        assertThat(foundCharacter).isPresent();
        assertThat(foundCharacter.get().getUser()).isEqualTo(user);
    }
}
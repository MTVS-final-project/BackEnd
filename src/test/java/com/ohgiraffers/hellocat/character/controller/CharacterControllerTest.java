package com.ohgiraffers.hellocat.character.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.hellocat.character.dto.CharacterUpdateRequestDto;
import com.ohgiraffers.hellocat.character.dto.CharacterUpdateResponseDto;
import com.ohgiraffers.hellocat.character.entity.Character;
import com.ohgiraffers.hellocat.character.service.CharacterService;
import com.ohgiraffers.hellocat.user.dto.UserFindResponseDto;
import com.ohgiraffers.hellocat.user.entity.User;
import com.ohgiraffers.hellocat.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = CharacterController.class)
class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private CharacterUpdateRequestDto requestDto;
    private CharacterUpdateResponseDto responseDto;

    @BeforeEach
    void setUp() {

        requestDto = new CharacterUpdateRequestDto();
        requestDto.setEye(1L);
        requestDto.setHair(3L);
        requestDto.setPants(43L);

        responseDto = CharacterUpdateResponseDto.builder()
                .eye(1L)
                .hair(3L)
                .pants(43L)
                .build();

        // 1번 유저를 호출하면 모킹 유저가 반환
        when(userService.findById(1L)).thenReturn(mockUserWithCharacter());

        // 해당 메서드가 아무 Long값과 RequestDto와 함께 호출되면 responseDto를 반환
        when(characterService.update(Mockito.anyLong(), Mockito.any(CharacterUpdateRequestDto.class)))
                .thenReturn(responseDto);

    }

    @Test
    @DisplayName("캐릭터 업데이트 성공 테스트")
    void testUpdateCharacter() throws Exception {

        // 해당 url에 요청을 보내면 Json으로 직렬화 된 값이 반환
        mockMvc.perform(post("/api/character/{userId}", 1L)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.eye").value(1L))
//                .andExpect(jsonPath("$.hair").value(3L))
//                .andExpect(jsonPath("$.pants").value(43L));
    }

    private UserFindResponseDto mockUserWithCharacter() {

        User user = new User();
        Character character = new Character();

        user.makeCharacter(character);

        return UserFindResponseDto.builder()
                .id(1L)
                .character(character)
                .build();
    }
}
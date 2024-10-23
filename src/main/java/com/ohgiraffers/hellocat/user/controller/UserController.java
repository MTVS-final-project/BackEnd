package com.ohgiraffers.hellocat.user.controller;

import com.ohgiraffers.hellocat.character.entity.Character;
import com.ohgiraffers.hellocat.user.dto.UserCreateResponseDto;
import com.ohgiraffers.hellocat.user.entity.User;
import com.ohgiraffers.hellocat.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "유저 API", description = "유저와 관련한 API")
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "유저 생성", description = "유저를 생성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "유저가 정상 생성되었습니다.")
    })
    public ResponseEntity<?> createUser() {

        User user = new User();
        Character character = new Character();
        user.makeCharacter(character);

        UserCreateResponseDto responseDto = userService.createUser(user);

        return ResponseEntity.status(201).body(responseDto);
    }
}

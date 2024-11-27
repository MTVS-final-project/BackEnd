package com.ohgiraffers.hellocat.cat.controller;

import com.ohgiraffers.hellocat.cat.dto.CatRequestDto;
import com.ohgiraffers.hellocat.cat.dto.CatResponseDto;
import com.ohgiraffers.hellocat.cat.dto.CatUpdateRequestDto;
import com.ohgiraffers.hellocat.cat.service.CatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@Tag(name = "고양이 API", description = "고양이 관련 API")
@Slf4j
@RestController
@RequestMapping("/api/v1/cat")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @PostMapping
    @Operation(summary = "고양이 저장", description = "유저의 고양이를 저장합니다.")
    @ApiResponse(responseCode = "201", description = "고양이가 정상 저장되었습니다.")
    public ResponseEntity<CatResponseDto> saveCat(@RequestBody CatRequestDto catRequestDto) {

        CatResponseDto responseDto = catService.saveCat(catRequestDto);

        return ResponseEntity.status(CREATED).body(responseDto);
    }

    @GetMapping
    @Operation(summary = "유저 아이디 기반 고양이 조회", description = "유저의 ID를 기반으로 고양이를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "고양이 조회 성공"),
            @ApiResponse(responseCode = "404", description = "고양이를 찾을 수 없습니다.")
    })
    public ResponseEntity<CatResponseDto> findCatByOwnerId(@RequestParam Long ownerId) {

        try {
            CatResponseDto responseDto = catService.findCatByOwnerId(ownerId);
            return ResponseEntity.status(OK).body(responseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }

    @PutMapping("/{catId}")
    @Operation(summary = "고양이 정보 수정", description = "고양이 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "고양이 정보가 정상 수정되었습니다."),
            @ApiResponse(responseCode = "404", description = "고양이를 찾을 수 없습니다.")
    })
    public ResponseEntity<CatResponseDto> updateCatInfo(@RequestBody CatUpdateRequestDto requestDto,
                                                    @PathVariable String catId) {

        try {
            CatResponseDto responseDto = catService.updateCatInfo(requestDto, catId);
            return ResponseEntity.status(OK).body(responseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }
}

package com.ohgiraffers.hellocat.swagger.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(customInfo());
    }

    private Info customInfo() {
        return new Info()
                .title("안냥 API")
                .description("안냥의 API 문서입니다. 도메인별로 정리되어 있습니다.")
                .version("0.0.1");
    }
}

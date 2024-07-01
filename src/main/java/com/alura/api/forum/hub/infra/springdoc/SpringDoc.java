package com.alura.api.forum.hub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDoc {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("API - Fórum Hub Challenge Back End")
                        .description("API REST da aplicação Fórum, contendo as funcionalidades de CRUD de usuarios, topicos, respostas e cursos")
                        .contact(new Contact()
                                .name("Luís Gabriel Barrichello")
                                .url("https://luisbarrichello.vercel.app/")
                        )
                        .license(new License()
                                .name("Apache 2.0")));
    }
}

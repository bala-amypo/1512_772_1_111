package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
            .addServersItem(new Server().url("https://9036.pro604cr.amypo.ai"))

            // 🔐 Add security scheme
            .components(new Components()
                .addSecuritySchemes("bearerAuth",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                )
            )

            // 🔐 Apply security globally
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))

            .info(new Info()
                .title("Hostel Roommate Compatibility Matcher API")
                .version("1.0")
                .description("API documentation for hostel roommate matching system")
            );
    }
}

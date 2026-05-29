package com.demo.travelcardsystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI alNaqelOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Al-Naqel Fare Card System API")
                        .description("REST API for the Al-Naqel transit card system. Allows commuters to register cards, load credit, and swipe in and out at stations. Fares are calculated automatically based on zones travelled.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("SWE473 Group - UAE Smart Travel Limited")
                                .email("swe473@adu.ac.ae")));
    }
}
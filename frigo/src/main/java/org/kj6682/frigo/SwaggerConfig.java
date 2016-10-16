package org.kj6682.frigo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket currentApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("frigo-api-v1")
          .select()                                  
          .apis(RequestHandlerSelectors.withClassAnnotation(ApiV1.class))
          .paths(PathSelectors.any())
          .build();
    }
    @Bean
    public Docket oldApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("frigo-api-v0")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(ApiV0.class))
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public Docket unstableApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("frigo-api-v2")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(ApiV2.class))
                .paths(PathSelectors.any())
                .build();
    }
}
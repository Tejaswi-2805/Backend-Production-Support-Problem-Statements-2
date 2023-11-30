package com.example.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.demo.ProductsCatalogueApplication;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(ProductsCatalogueApplication.class)
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2);
//        		.select()
//        		.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Swagger")
//                .description("API Description")
//                .termsOfServiceUrl("http://localhost:8080/")
//                .licenseUrl("tejaswikatakam1999@gmail.com")
//                .version("2.0").build();
//                .contact(new Contact("Tejaswi", "http://localhost:8080/", "tejaswikatakam99@example.com"))
//                .build();
//    }

}

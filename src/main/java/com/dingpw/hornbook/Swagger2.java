package com.dingpw.hornbook;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 14:01.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createUserApi() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        parameterBuilder
            .name("x-access-uid")
            .description("userId")
            .modelRef(new ModelRef("long"))
            .parameterType("header")
            .required(false)
            .name("x-access-vc")
            .description("versionCode")
            .modelRef(new ModelRef("long"))
            .parameterType("header")
            .required(false)
            .name("x-access-p")
            .description("platform")
            .modelRef(new ModelRef("long"))
            .parameterType("header")
            .required(false)
            .build();
        parameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_12)
            .groupName("userApi")
            .apiInfo(apiInfo("userApi", "userApi"))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.dingpw.hornbook.api.user"))
            .paths(PathSelectors.any())
            .build().globalOperationParameters(parameters);
    }

    @Bean
    public Docket createOfficerApi() {
        return new Docket(DocumentationType.SWAGGER_12)
            .groupName("officerApi")
            .apiInfo(apiInfo("officerApi", "officerApi"))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.dingpw.hornbook.api.officer"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
            .title(title)
            .description(description)
            .termsOfServiceUrl("localhost:8080/")
            .version("1.0")
            .build();
    }

    @Bean
    public UiConfigurationBuilder uiConfig() {
        return UiConfigurationBuilder.builder();
    }
}

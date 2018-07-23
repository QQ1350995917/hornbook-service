package com.dingpw.hornbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_12)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.dingpw.hornbook.api"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("springboot利用swagger构建api文档")
            .description("简单优雅的restfun风格，")
            .termsOfServiceUrl("localhost:8080/")
            .version("1.0")
            .build();
    }
}

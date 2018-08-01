package com.dingpw.hornbook;

import com.dingpw.hornbook.api.ApiInputValidateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-01 10:17.
 */
@Configuration
public class ApplicationWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiInputValidateInterceptor()).addPathPatterns("/api/*");
    }
}

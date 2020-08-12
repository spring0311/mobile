package cn.laike.management.blog.config;

import cn.laike.management.blog.handler.LoginInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

public class InterceptorConfigration /*implements WebMvcConfigurer */ {


    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor = new LoginInterceptor();

        List<String> patterns = new ArrayList<>();
        patterns.add("/blog/users/login");

        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns(patterns);

    }


}

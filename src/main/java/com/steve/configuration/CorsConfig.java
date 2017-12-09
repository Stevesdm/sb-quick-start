package com.steve.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by SteveJobson on 2017/8/3.
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

    //可以根据逻辑结合细粒度@CrossOrigin进行配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("swagger2/**")
                .allowedOrigins("http://www.demo.com")
                .allowedMethods("GET", "POST", "DELETE", "PUT");

    }
}

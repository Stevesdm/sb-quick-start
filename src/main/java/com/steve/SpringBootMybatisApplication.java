package com.steve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan(basePackages = "com.steve.dao")//或者使用在Mapper类上添加@Mapper的方法
public class SpringBootMybatisApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {

        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

}

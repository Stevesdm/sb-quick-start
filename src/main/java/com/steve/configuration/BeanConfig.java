package com.steve.configuration;

import com.steve.spring.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/16 下午10:44
 */
@Configuration
public class BeanConfig {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public DemoBean getDemobean(){
        return new DemoBean();
    }
}

package com.steve.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/16 下午10:44
 */
public class DemoBean {

    //指定init和destory method 通过 @PostConstruct注解或者@Bean(initMethod="")方式，二选一
    @PostConstruct
    public void init(){
        System.out.println("Demo bean init.....");
    }

    public DemoBean(){
        System.out.println("Demo bean constructor");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Demo bean destroy.....");
    }
}

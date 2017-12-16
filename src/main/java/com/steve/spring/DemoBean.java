package com.steve.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/16 下午10:44
 */
public class DemoBean {


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

package com.steve.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by SteveJobson on 2017/8/9.
 */
@Component
@ManagedResource(objectName = "bean:name=stevejobson",description = "My test jmx mbean")
public class JmxMonitorTest {

    private String name ;
    private Integer age=10;

    @ManagedAttribute
    public String getName() {
        return name;
    }
    @ManagedAttribute
    public void setName(String name) {
        this.name = name;
    }
    @ManagedAttribute
    public Integer getAge() {
        return age;
    }
    @ManagedAttribute
    public void setAge(Integer age) {
        this.age = age;
    }

    @Scheduled(cron = "* * * * * *")
    public void t1(){
        this.setAge(this.getAge() + 1);
    }
}

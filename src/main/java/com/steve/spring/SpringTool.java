package com.steve.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: stevejobson
 * @CreateDate: 2017/12/13 上午9:55
 */
@Component
public class SpringTool implements ApplicationContextAware {


    private static ApplicationContext ac = null;

    private static SpringTool SpringTool = null;

    public synchronized static SpringTool init() {
        if (SpringTool == null) {
            SpringTool = new SpringTool();
        }
        return SpringTool;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac =applicationContext;
    }

    public synchronized static Object getBean(String beanName) {
        return ac.getBean(beanName);
    }
}

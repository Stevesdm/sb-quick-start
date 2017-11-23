package com.steve.configuration;

import com.alibaba.druid.support.http.WebStatFilter;
import com.steve.configuration.filter.ApiFrequencyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SteveJobson on 2017/7/28.
 */
@Configuration
public class FilterConfig {

    @Bean
    public ApiFrequencyFilter getApiFrequencyFilter(){
        return new ApiFrequencyFilter();
    }

    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //不需要过滤
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.css,*.gif,*.jpg,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean apiFrequencyFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(getApiFrequencyFilter());
        filterRegistrationBean.addUrlPatterns("/test/swagger2/*");
        return filterRegistrationBean;
    }
}

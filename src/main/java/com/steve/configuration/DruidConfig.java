package com.steve.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by SteveJobson on 2017/7/28.
 */
@Configuration
@ConfigurationProperties(prefix = "druid")
@PropertySource("classpath:config/druid.properties")
public class DruidConfig {


    private String username;
    private String password;
    private String whiteIp;
    private String blackIp;

    @Bean
    public ServletRegistrationBean DruidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //白名单
        servletRegistrationBean.addInitParameter("allow", this.getWhiteIp());
        //黑名单(同时存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", this.getBlackIp());
        //登录信息
        servletRegistrationBean.addInitParameter("loginUsername", this.getUsername());
        servletRegistrationBean.addInitParameter("loginPassword", this.getPassword());
        //是否能重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }


    /**
     * get&set
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWhiteIp() {
        return whiteIp;
    }

    public void setWhiteIp(String whiteIp) {
        this.whiteIp = whiteIp;
    }

    public String getBlackIp() {
        return blackIp;
    }

    public void setBlackIp(String blackIp) {
        this.blackIp = blackIp;
    }
}

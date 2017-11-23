package com.steve.configuration.filter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by SteveJobson on 2017/8/5.
 */
@Component
public class ApiFrequencyFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiFrequencyFilter.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    String apiFrequency = "test.swagger2.frequency:";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//        String ip = IpUtil.getIpAddr(httpServletRequest);
        String ip =""; //TODO
        String apiKey = apiFrequency+ip;
        System.out.println(apiKey);
        redisTemplate.setKeySerializer(new GenericToStringSerializer<String>(String.class));
        ValueOperations valueOperations = redisTemplate.opsForValue();
        boolean flag = valueOperations.getOperations().hasKey(apiKey);
        if (flag) {
            System.out.println("存在");
            stringRedisTemplate.boundValueOps(apiKey).increment(1L);
        } else {
            System.out.println("不存在");
            stringRedisTemplate.boundValueOps(apiKey).increment(1L);
            stringRedisTemplate.expire(apiKey, 30 , TimeUnit.SECONDS);
        }


        if (Long.parseLong(stringRedisTemplate.boundValueOps(apiKey).get())   > 3) {
            httpServletResponse.sendRedirect("/error/swagger2/test");
            return;
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
    }
}

package com.steve.swagger2;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SteveJobson on 2017/8/5.
 */
@RestController
@RequestMapping(value="/test/api")
public class DemoApi {

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value="测试文档", notes="")
    @RequestMapping(value="/test01")
    public String test01() {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("name","steve");
        String name = operations.get("name");
        return "test1111111111111" + name;
    }
}

package com.steve;

import com.steve.domain.User;
import com.steve.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootMybatisApplication.class)
public class SpringBootMybatisApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUserId("1001");
        user.setUserName("stevess");
        user.setUserAge(18);
        int result = userService.addUser(user);
        System.out.println(result);
    }
}

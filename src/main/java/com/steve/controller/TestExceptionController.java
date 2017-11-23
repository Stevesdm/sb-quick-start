package com.steve.controller;

import com.steve.base.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SteveJobson on 2017/9/27.
 */
@RestController
public class TestExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(TestExceptionController.class);

    @RequestMapping("/exception")
    public String TestException() throws Exception {
        throw new Exception();
    }


    @RequestMapping("/myexception")
    public String TestMyException() throws Exception {
        throw new MyException();
    }
}

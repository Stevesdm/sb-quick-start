package com.steve.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SteveJobson on 2017/9/27.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Map defaultExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        Map<String, Object> msg = new HashMap<>();
        msg.put("exception", e);
        msg.put("url", request.getRequestURL());
        return msg;
    }

    @ExceptionHandler(value = MyException.class)
    public Map myExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        Map<String, Object> msg = new HashMap<>();
        msg.put("my exception", e);
        msg.put("my url", request.getRequestURL());
        return msg;
    }
}

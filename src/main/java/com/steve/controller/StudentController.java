package com.steve.controller;

import com.steve.domain.Student;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by SteveJobson on 2017/8/2.
 */
@RestController
@RequestMapping("/student")
public class StudentController {


    @RequestMapping("/test")
    public String testStudent(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return result.getAllErrors().toString();
        }
        return "success";
    }
}

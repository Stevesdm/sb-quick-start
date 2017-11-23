package com.steve.swagger2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by SteveJobson on 2017/8/5.
 */
@RestController
@RequestMapping(value="/error/api")
public class ErrorApi {

    @ApiIgnore
    @RequestMapping(value="test")
    public String error() {
        return "error    beyond    frequency";
    }
}

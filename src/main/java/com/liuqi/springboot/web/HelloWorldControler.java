package com.liuqi.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControler {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World144444";
    }

}

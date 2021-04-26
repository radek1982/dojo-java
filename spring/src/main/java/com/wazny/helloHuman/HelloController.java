package com.wazny.helloHuman;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(@RequestParam(required = false) String name) {
        if (StringUtils.isEmpty(name)) name = "Human";
        return "<h1> Hello " + name + " </h1><p> Welcome to Spring Boot </p>";
    }
}

package com.wazny;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    @GetMapping("/")
        public String hello() {
        return "Hello Client How are you doing?";
        }
        @GetMapping("/random")
        public String random() {
        return "Spring Boot is great! So easy to respond with strings";
        }


}

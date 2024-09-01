package com.rupicodes.Rest.API.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class RestControllerDemo {

    @GetMapping("/hello")
    private String getMessage() {
        return "Hello World";
    }
}

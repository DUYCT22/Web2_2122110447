package com.nguyennhutduy.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloWordController {

    @GetMapping("/")
    public String hello() {
        return "hello word";
    }

    @PostMapping("/post")
    public Integer post(@RequestBody String request) {
        int a = 2;
        int b = 123123;
        return a + b;
    }

    @PutMapping("path/{id}")
    public Integer put(@PathVariable String id, @RequestBody String entity) {
        int a = 2;
        int b = 123123;
        return a + b;
    }
}
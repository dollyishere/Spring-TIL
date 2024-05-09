package com.ljy.dev.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;


@Controller
@Log4j2
public class SimpleController {
    @GetMapping("/hello")
    public String hello(Model model) {
        log.info("hello.................?");
        model.addAttribute("msg", "HELLO WORLD!");
        return "hello/hello"; // hello.html 템플릿을 반환
    }
}
package com.spring.study.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!!!");
        return "hello";
    }

    @GetMapping("hello/template")
    public String helloTemplate(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("text",name);
        return "helloTemplate";
    }
}

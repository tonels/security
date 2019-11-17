package com.example.security.securityjdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeResource {

    @GetMapping("/")
    public String home(){
        return "<h1> Welcome Home</h1>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h1> 普通用户的权限";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1> 管理员的的权限";
    }



}

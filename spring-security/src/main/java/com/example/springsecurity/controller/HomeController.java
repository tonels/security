package com.example.springsecurity.controller;

import org.hibernate.validator.internal.constraintvalidators.bv.size.SizeValidatorForArraysOfByte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "<h1> Welcome Tonels</h1>";
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
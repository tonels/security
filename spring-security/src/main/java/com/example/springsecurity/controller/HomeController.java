package com.example.springsecurity.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "<h1> Welcome Tonels</h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1> 普通用户的权限";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1> 管理员的的权限";
    }

    /**
     * 获取当前用户信息（userName）
     * 无用户登陆时 返回 anonymousUser
     *
     * @param request
     * @return
     */
    @GetMapping("/currentUser")
    public String currentUser(HttpServletRequest request) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails) {
                        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                        return springSecurityUser.getUsername();
                    } else if (authentication.getPrincipal() instanceof String) {
                        return (String) authentication.getPrincipal();
                    }
                    return null;
                }).orElse(null);
    }


}

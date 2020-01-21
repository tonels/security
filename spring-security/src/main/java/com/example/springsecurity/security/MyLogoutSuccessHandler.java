package com.example.springsecurity.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("myLogoutSuccessHandler")
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException {
        System.out.println("-LogoutSuccessHandler--------退出成功");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write("logout success...");
    }

}

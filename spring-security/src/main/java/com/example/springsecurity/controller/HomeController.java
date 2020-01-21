package com.example.springsecurity.controller;

import com.example.springsecurity.repository.UserRepository;
import com.example.springsecurity.security.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Locale;

@Controller
public class HomeController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/loggedUsers", method = RequestMethod.GET)
    public String getLoggedUsers(final Locale locale, final Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value = "/loggedUsersFromSessionRegistry", method = RequestMethod.GET)
    public String getLoggedUsersFromSessionRegistry(final Locale locale, final Model model) {
        model.addAttribute("users", SecurityUtils.getCurrentUserLogin());
        return "users";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(final Locale locale, final Model model) {
        model.addAttribute("users", SecurityUtils.getCurrentUserLogin());
        return "users";
    }

}

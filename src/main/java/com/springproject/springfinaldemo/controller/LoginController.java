package com.springproject.springfinaldemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String ShowMyLoginPage()
    {
        return "Plain-login";
    }


    @GetMapping("/")
    public String showHome() {

        return "home";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}

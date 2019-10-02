package com.ideaas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = {"/home" , ""})
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/perform_login")
    public String doLogin(@RequestParam("username") String username, @RequestParam String password) {
        System.out.println("ok");
        return "ok";
    }

}


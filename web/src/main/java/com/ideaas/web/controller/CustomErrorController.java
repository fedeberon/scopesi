package com.ideaas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, WebRequest webRequest, Model model) {

        if (HttpStatus.NOT_FOUND.value() == (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)) {
            return "/error/404";
        }

        return "error";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}

package com.ideaas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tablas")
public class TablaController{



    @RequestMapping()
    public String tabla(){ return "tabla";
    }

}

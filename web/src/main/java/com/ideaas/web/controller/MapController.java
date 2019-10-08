package com.ideaas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by federicoberon on 08/10/2019.
 */
@Controller
@RequestMapping("maps")
public class MapController {

    @RequestMapping("show")
    public String maps(){
        return "maps";
    }



}

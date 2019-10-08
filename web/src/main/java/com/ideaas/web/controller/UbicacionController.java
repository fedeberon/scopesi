package com.ideaas.web.controller;

import com.ideaas.services.service.interfaces.AudUbicacionService;
import com.ideaas.services.service.interfaces.MapUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by federicoberon on 08/10/2019.
 */

@Controller
@RequestMapping("ubicacion")
public class UbicacionController {


    @Autowired
    private MapUbicacionService mapUbicacionService;

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("ubicaciones", mapUbicacionService.findAll(size, page, "id"));

        return "ubicacion/list";

    }



}

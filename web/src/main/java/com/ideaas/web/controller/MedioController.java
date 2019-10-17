package com.ideaas.web.controller;


import com.ideaas.services.domain.MapMedio;
import com.ideaas.services.service.interfaces.MapMedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("medio")
public class MedioController {

    private MapMedioService medioService;

    @Autowired
    public MedioController(MapMedioService medioService) {
        this.medioService = medioService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapMedioService medio = (MapMedioService) medioService.get(id);

        model.addAttribute("medios", medio);

        return "medio/show";
    }

    @GetMapping
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<MapMedio> medios = medioService.findAll(size, page,"id");

        model.addAttribute("medios", medios);

        return "medio/list";
    }


}
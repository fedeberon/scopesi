package com.ideaas.web.controller;


import com.ideaas.services.domain.MapMedio;
import com.ideaas.services.domain.MapProvincia;
import com.ideaas.services.service.interfaces.MapMedioService;
import com.ideaas.services.service.interfaces.MapProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("provincia")
public class ProvinciaController {

    private MapProvinciaService provinciaService;

    @Autowired
    public ProvinciaController(MapProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapProvinciaService provincia = (MapProvinciaService) provinciaService.get(id);

        model.addAttribute("provincia", provincia);

        return "provincia/show";
    }

    @GetMapping
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<MapProvincia> provincias = provinciaService.findAll(size, page,"id");

        model.addAttribute("provincias", provincias);

        return "provincia/list";
    }


}
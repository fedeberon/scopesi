package com.ideaas.web.controller;

import com.ideaas.services.domain.MapFormato;
import com.ideaas.services.service.interfaces.MapFormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("formato")
public class FormatoController{

    private MapFormatoService formatoService;

    @Autowired
    public FormatoController(MapFormatoService formatoService) {
        this.formatoService = formatoService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapFormatoService formato = (MapFormatoService) formatoService.get(id);

        model.addAttribute("formato", formato);

        return "formato/show";
    }

    @GetMapping
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<MapFormato> formatos = formatoService.findAll(size, page,"id");

        model.addAttribute("formatos", formatos);

        return "formato/list";
    }


}
package com.ideaas.web.controller;

import com.ideaas.services.domain.MapElemento;
import com.ideaas.services.service.interfaces.MapElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("elemento")
public class ElementoController {

    private MapElementoService elementoService;

    @Autowired
    public ElementoController(MapElementoService elementoService) {

        this.elementoService = elementoService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("elemento", elementoService.get(id));

        return "elemento/show";
    }

    @GetMapping
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        model.addAttribute("elementos", elementoService.findAll(size, page,"id"));

        return "elemento/list";
    }


    @GetMapping("create")
    public String create() {
        return "elemento/create";
    }

    @ModelAttribute("elemento")
    public MapElemento get(){
        return new MapElemento();
    }


}
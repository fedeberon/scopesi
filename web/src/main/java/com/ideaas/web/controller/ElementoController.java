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

    @GetMapping("show")
    public String show(@RequestParam Long id, Model model) {
        MapElementoService elemento = (MapElementoService) elementoService.get(id);

        model.addAttribute("elemento", elemento);

        return "elemento/show";
    }

    @GetMapping ("list")
        public String findAll(@RequestParam(defaultValue = "10") Integer size,
                              @RequestParam(defaultValue = "0") Integer page, Model model){
        List<MapElemento> elementos = elementoService.findAll(size, page,"id");
        model.addAttribute("elementos", elementos);
        model.addAttribute("page" , page);

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
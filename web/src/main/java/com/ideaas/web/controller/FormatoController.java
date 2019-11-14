package com.ideaas.web.controller;

import com.ideaas.services.domain.MapFormato;
import com.ideaas.services.service.interfaces.MapFormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<MapFormato> formatos = formatoService.findAll(size, page,"id");

        model.addAttribute("formatos", formatos);
        model.addAttribute("page",page);

        return "formato/list";
    }

    @GetMapping("create")
    public String create() {
        return "formato/create";
    }


    @PostMapping("addFormato")
    public String save(@ModelAttribute MapFormato formato, RedirectAttributes redirectAttributes){
        formatoService.save(formato);
        redirectAttributes.addAttribute("id", formato.getId());

        return "redirect:/{id}";
    }

    @PutMapping("editFormato")
    public String edit(@ModelAttribute MapFormato formato, RedirectAttributes redirectAttributes){
        formatoService.save(formato);
        redirectAttributes.addAttribute("id", formato.getId());

        return "redirect:/{id}";
    }

    @ModelAttribute("formato")
    public MapFormato get(){
        return new MapFormato();
    }



}
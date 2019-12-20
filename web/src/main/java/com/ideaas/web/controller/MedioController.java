package com.ideaas.web.controller;


import com.ideaas.services.domain.MapFormato;
import com.ideaas.services.domain.MapMedio;
import com.ideaas.services.service.interfaces.MapMedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("medio")
public class MedioController {

    private MapMedioService medioService;

    private static final Boolean INACTIVE = true;


    @Autowired
    public MedioController(MapMedioService medioService) {
        this.medioService = medioService;
    }

    @GetMapping ("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapMedio medio = medioService.get(id);

        model.addAttribute("medio", medio);

        return "medio/show";
    }

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<MapMedio> medios = medioService.findAll(size, page,"id");

        model.addAttribute("medios", medios);
        model.addAttribute("page" , page);

        return "medio/list";
    }

    @GetMapping("create")
    public String create() {
        return "medio/create";
    }


    @PostMapping("addMedio")
    public String save(@ModelAttribute MapMedio medio, RedirectAttributes redirectAttributes){
        medioService.save(medio);
        redirectAttributes.addAttribute("id", medio.getId());

        return "redirect:/medio/{id}";
    }

    @PutMapping("editMedio")
    public String edit(@ModelAttribute MapMedio medio, RedirectAttributes redirectAttributes){
        medioService.save(medio);
        redirectAttributes.addAttribute("id", medio.getId());

        return "redirect:/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        MapMedio mapMedio = medioService.get(id);
        model.addAttribute("medio", mapMedio);
        return "medio/update";
    }

    @RequestMapping("dropBajaLogica")
    public String dropBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapMedio mapMedio = medioService.get(id);
        mapMedio.setBajaLogica(INACTIVE);
        medioService.save(mapMedio);
        redirectAttributes.addAttribute("id", mapMedio.getId());

        return "redirect:/medio/{id}";
    }

    @RequestMapping("upBajaLogica")
    public String upBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapMedio mapMedio = medioService.get(id);
        mapMedio.setBajaLogica(!INACTIVE);
        medioService.save(mapMedio);
        redirectAttributes.addAttribute("id", mapMedio.getId());

        return "redirect:/medio/{id}";
    }


    @ModelAttribute("medio")
        public MapMedio get(){return new MapMedio();}
}
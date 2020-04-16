package com.ideaas.web.controller;


import com.ideaas.services.domain.MapMedio;
import com.ideaas.services.domain.MapProvincia;
import com.ideaas.services.service.interfaces.MapMedioService;
import com.ideaas.services.service.interfaces.MapProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("provincia")
public class ProvinciaController {

    private MapProvinciaService provinciaService;

    private static final Boolean INACTIVE = true;

    @Autowired
    public ProvinciaController(MapProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapProvincia provincia = provinciaService.get(id);

        model.addAttribute("provincia", provincia);

        return "provincia/show";
    }

    @GetMapping("list")
    public String findAll(Model model){
        List<MapProvincia> provincias = provinciaService.findAll();

        model.addAttribute("provincias", provincias);

        return "provincia/list";
    }

    @GetMapping("create")
    public String create() {
        return "provincia/create";
    }


    @PostMapping("addProvincia")
    public String save(@ModelAttribute MapProvincia provincia, RedirectAttributes redirectAttributes){
        provinciaService.save(provincia);
        redirectAttributes.addAttribute("id", provincia.getId());

        return "redirect:/provincia/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        MapProvincia mapProvincia = provinciaService.get(id);
        model.addAttribute("provincia", mapProvincia);
        return "provincia/update";
    }

    @RequestMapping("dropBajaLogica")
    public String dropBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapProvincia mapProvincia = provinciaService.get(id);
        mapProvincia.setBajaLogica(INACTIVE);
        provinciaService.save(mapProvincia);
        redirectAttributes.addAttribute("id", mapProvincia.getId());

        return "redirect:/provincia/{id}";
    }

    @RequestMapping("upBajaLogica")
    public String upBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapProvincia mapProvincia = provinciaService.get(id);
        mapProvincia.setBajaLogica(!INACTIVE);
        provinciaService.save(mapProvincia);
        redirectAttributes.addAttribute("id", mapProvincia.getId());

        return "redirect:/provincia/{id}";
    }

    @ModelAttribute ("provincia")
    public MapProvincia get() {return new MapProvincia();}

}
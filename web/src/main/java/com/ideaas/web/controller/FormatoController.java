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

    private static final Boolean INACTIVE = true;

    @Autowired
    public FormatoController(MapFormatoService formatoService) {
        this.formatoService = formatoService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapFormato formato = formatoService.get(id);

        model.addAttribute("formato", formato);

        return "formato/show";
    }

    @GetMapping("list")
    public String findAll(Model model){
        List<MapFormato> formatos = formatoService.findAll();

        model.addAttribute("formatos", formatos);

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

        return "redirect:/formato/{id}";
    }

    @PutMapping("editFormato")
    public String edit(@ModelAttribute MapFormato formato, RedirectAttributes redirectAttributes){
        formatoService.save(formato);
        redirectAttributes.addAttribute("id", formato.getId());

        return "redirect:/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        MapFormato mapFormato = formatoService.get(id);
        model.addAttribute("formato", mapFormato);
        return "formato/update";
    }

    @RequestMapping("dropBajaLogica")
    public String dropBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapFormato mapFormato = formatoService.get(id);
        mapFormato.setBajaLogica(INACTIVE);
        formatoService.save(mapFormato);
        redirectAttributes.addAttribute("id", mapFormato.getId());

        return "redirect:/formato/{id}";
    }

    @RequestMapping("upBajaLogica")
    public String updateBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapFormato mapFormato = formatoService.get(id);
        mapFormato.setBajaLogica(!INACTIVE);
        formatoService.save(mapFormato);
        redirectAttributes.addAttribute("id", mapFormato.getId());

        return "redirect:/formato/{id}";
    }

    @ModelAttribute("formato")
    public MapFormato get(){
        return new MapFormato();
    }



}
package com.ideaas.web.controller;


import com.ideaas.services.domain.AudLocalidad;
import com.ideaas.services.service.interfaces.AudLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("localidad")
public class LocalidadController {

    private AudLocalidadService localidadService;

    @Autowired
        public LocalidadController(AudLocalidadService localidadService) {
        this.localidadService = localidadService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        AudLocalidad localidad = localidadService.get(id);

        model.addAttribute("localidad", localidad);

        return "localidad/show";
    }

    @GetMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<AudLocalidad> localidades = localidadService.findAll(size, page,"id");

        model.addAttribute("localidades", localidades);
        model.addAttribute("page" , page);

        return "localidad/list";
    }

    @GetMapping("create")
    public String create() {
        return "localidad/create";
    }

    @PostMapping("addLocalidad")
    public String save(@ModelAttribute AudLocalidad localidad, RedirectAttributes redirectAttributes){
        localidadService.save(localidad);
        redirectAttributes.addAttribute("id", localidad.getId());
        return "redirect:/localidad/{id}";
    }

    @ModelAttribute("localidad")
    public AudLocalidad get(){ return  new AudLocalidad();}
}
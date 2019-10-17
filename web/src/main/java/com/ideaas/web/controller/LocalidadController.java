package com.ideaas.web.controller;


import com.ideaas.services.domain.AudLocalidad;
import com.ideaas.services.service.interfaces.AudLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        AudLocalidadService localidad = (AudLocalidadService) localidadService.get(id);

        model.addAttribute("localidad", localidad);

        return "localidad/show";
    }

    @GetMapping
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<AudLocalidad> localidades = localidadService.findAll(size, page,"id");

        model.addAttribute("localidades", localidades);

        return "localidad/list";
    }


}
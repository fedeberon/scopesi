package com.ideaas.web.controller;

import com.ideaas.services.domain.MapLocalidad;
import com.ideaas.services.domain.MapProvincia;
import com.ideaas.services.service.interfaces.MapLocalidadService;
import com.ideaas.services.service.interfaces.MapProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("localidad")
public class LocalidadController {

    private MapLocalidadService localidadService;
    private MapProvinciaService mapProvinciaService;

    private static final Boolean INACTIVE = true;


    @Autowired
        public LocalidadController(MapLocalidadService localidadService, MapProvinciaService mapProvinciaService) {
        this.localidadService = localidadService;
        this.mapProvinciaService = mapProvinciaService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapLocalidad localidad = localidadService.get(id);

        model.addAttribute("localidad", localidad);

        return "localidad/show";
    }

    @GetMapping("list")
    public String findAll(Model model){
        List<MapLocalidad> localidades = localidadService.findAll();

        model.addAttribute("localidades", localidades);

        return "localidad/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        List<MapProvincia> provincias = mapProvinciaService.findAll();
        model.addAttribute("provincias", provincias);

        return "localidad/create";
    }

    @PostMapping("addLocalidad")
    public String save(@ModelAttribute MapLocalidad localidad, RedirectAttributes redirectAttributes){
        localidadService.save(localidad);
        redirectAttributes.addAttribute("id", localidad.getId());
        return "redirect:/localidad/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        MapLocalidad mapLocalidad = localidadService.get(id);
        model.addAttribute("localidad", mapLocalidad);
        return "localidad/update";
    }

    @RequestMapping("dropBajaLogica")
    public String dropBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapLocalidad mapLocalidad = localidadService.get(id);
        mapLocalidad.setBajaLogica(INACTIVE);
        localidadService.save(mapLocalidad);
        redirectAttributes.addAttribute("id", mapLocalidad.getId());

        return "redirect:/localidad/{id}";
    }

    @RequestMapping("upBajaLogica")
    public String upBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapLocalidad mapLocalidad = localidadService.get(id);
        mapLocalidad.setBajaLogica(!INACTIVE);
        localidadService.save(mapLocalidad);
        redirectAttributes.addAttribute("id", mapLocalidad.getId());

        return "redirect:/localidad/{id}";
    }

    @ModelAttribute("localidad")
    public MapLocalidad get(){ return  new MapLocalidad();}

    @ModelAttribute("provincias")
    public List<MapProvincia> provincias(){
        return mapProvinciaService.findAll();
    }
}
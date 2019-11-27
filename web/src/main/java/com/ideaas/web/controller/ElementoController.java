package com.ideaas.web.controller;

import com.ideaas.services.domain.MapElemento;
import com.ideaas.services.domain.MapFormato;
import com.ideaas.services.domain.MapMedio;
import com.ideaas.services.service.interfaces.MapElementoService;
import com.ideaas.services.service.interfaces.MapFormatoService;
import com.ideaas.services.service.interfaces.MapMedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("elemento")
public class ElementoController {

    private MapElementoService elementoService;
    private MapMedioService mapMedioService;
    private MapFormatoService mapFormatoService;

    private static final Boolean INACTIVE = true;


    @Autowired
    public ElementoController(MapElementoService elementoService, MapMedioService mapMedioService, MapFormatoService mapFormatoService) {

        this.elementoService = elementoService;
        this.mapMedioService = mapMedioService;
        this.mapFormatoService = mapFormatoService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapElemento elemento = elementoService.get(id);

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
    public String create(Model model) {
        List<MapMedio> medios = mapMedioService.findAll();
        List<MapFormato> formatos = mapFormatoService.findAll();
        model.addAttribute("formatos", formatos);
        model.addAttribute("medios", medios);

        return "elemento/create";
    }


    @PostMapping("addElemento")
    public String save(@ModelAttribute MapElemento elemento, RedirectAttributes redirectAttributes){
        elementoService.save(elemento);
        redirectAttributes.addAttribute("id", elemento.getId());

        return "redirect:/elemento/{id}";
    }

    @PutMapping("editElemento")
    public String edit(@ModelAttribute MapElemento elemento, RedirectAttributes redirectAttributes){
        elementoService.save(elemento);
        redirectAttributes.addAttribute("id", elemento.getId());

        return "redirect:/elemento/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        MapElemento mapElemento = elementoService.get(id);
        model.addAttribute("elemento", mapElemento);
        return "elemento/update";
    }

    @RequestMapping("updateBajaLogica")
    public String updateBajaLogica(@RequestParam Long id, Model model, RedirectAttributes redirectAttributes){
        MapElemento mapElemento = elementoService.get(id);
        mapElemento.setBajaLogica(INACTIVE);
        elementoService.save(mapElemento);
        redirectAttributes.addAttribute("id", mapElemento.getId());

        return "redirect:/elemento/{id}";
    }

    @ModelAttribute("elemento")
    public MapElemento get(){
        return new MapElemento();
    }

    @ModelAttribute("medios")
    public List<MapMedio> medios(){
        return mapMedioService.findAll();
    }

    @ModelAttribute("formatos")
    public List<MapFormato> formatos(){
        return mapFormatoService.findAll();
    }

}
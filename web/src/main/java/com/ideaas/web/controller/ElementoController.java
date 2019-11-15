package com.ideaas.web.controller;

import com.ideaas.services.domain.MapElemento;
import com.ideaas.services.service.interfaces.MapElementoService;
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

    @Autowired
    public ElementoController(MapElementoService elementoService) {

        this.elementoService = elementoService;
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
    public String create() {
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

    @ModelAttribute("elemento")
    public MapElemento get(){
        return new MapElemento();
    }


}
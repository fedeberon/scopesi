package com.ideaas.web.controller;

import com.ideaas.services.domain.MapPoi;
import com.ideaas.services.domain.MapPoiEntidad;
import com.ideaas.services.service.interfaces.MapPoiEntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("poiEntidad")
public class PoiEntidadController{

    private MapPoiEntidadService poiEntidadService;

    @Autowired
    public PoiEntidadController(MapPoiEntidadService poiEntidadService) {
        this.poiEntidadService = poiEntidadService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapPoiEntidadService poiEntidades = (MapPoiEntidadService) poiEntidadService.get(id);

        model.addAttribute("poiEntidades", poiEntidades);

        return "poiEntidad/show";
    }

    @GetMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<MapPoiEntidad> poiEntidades = poiEntidadService.findAll(size, page,"id");

        model.addAttribute("poiEntidades", poiEntidades);
        model.addAttribute("page" , page);

        return "poiEntidad/list";
    }

    @ModelAttribute("poiEntidad")
    public MapPoiEntidad get(){
        return new MapPoiEntidad();
    }

}
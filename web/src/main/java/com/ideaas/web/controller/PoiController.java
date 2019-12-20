package com.ideaas.web.controller;

import com.ideaas.services.domain.MapPoi;
import com.ideaas.services.domain.MapPoiEntidad;
import com.ideaas.services.domain.MapProvincia;
import com.ideaas.services.service.interfaces.MapPoiEntidadService;
import com.ideaas.services.service.interfaces.MapPoiService;
import com.ideaas.services.service.interfaces.MapProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("poi")
public class PoiController {

    private MapPoiService mapPoiService;
    private MapPoiEntidadService mapPoiEntidadService;
    private MapProvinciaService mapProvinciaService;

    private static final Boolean INACTIVE = true;

    @Autowired
    public PoiController(MapPoiService mapPoiService, MapPoiEntidadService mapPoiEntidadService, MapProvinciaService mapProvinciaService) {
        this.mapPoiService = mapPoiService;
        this.mapPoiEntidadService = mapPoiEntidadService;
        this.mapProvinciaService = mapProvinciaService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapPoi poi = mapPoiService.get(id);

        model.addAttribute("poi", poi);

        return "poi/show";
    }

    @GetMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model) {
        List<MapPoi> pois = mapPoiService.findAll(size, page, "id");

        model.addAttribute("pois", pois);
        model.addAttribute("page" , page);

        return "poi/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        List<MapPoiEntidad> poiEntidades = mapPoiEntidadService.findAll();
        List<MapProvincia> provincias = mapProvinciaService.findAll();
        model.addAttribute("poiEntidades", poiEntidades);
        model.addAttribute("provincias", provincias);

        return "poi/create";
    }

    @PostMapping("addPoi")
    public String save(@ModelAttribute MapPoi poi, RedirectAttributes redirectAttributes){
        mapPoiService.save(poi);
        redirectAttributes.addAttribute("id", poi.getId());
        return "redirect:/poi/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        MapPoi mapPoi = mapPoiService.get(id);
        model.addAttribute("poi", mapPoi);
        model.addAttribute("poiEntidad", mapPoi.getMapPoiEntidad().getDescripcion());

        return "poi/update";
    }

    @RequestMapping("dropBajaLogica")
    public String dropBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapPoi mapPoi = mapPoiService.get(id);
        mapPoi.setBajaLogica(INACTIVE);
        mapPoiService.save(mapPoi);
        redirectAttributes.addAttribute("id", mapPoi.getId());

        return "redirect:/poi/{id}";
    }

    @RequestMapping("upBajaLogica")
    public String upBajaLogica(@RequestParam Long id, RedirectAttributes redirectAttributes){
        MapPoi mapPoi = mapPoiService.get(id);
        mapPoi.setBajaLogica(!INACTIVE);
        mapPoiService.save(mapPoi);
        redirectAttributes.addAttribute("id", mapPoi.getId());

        return "redirect:/poi/{id}";
    }

    @ModelAttribute("poiEntidades")
    public List<MapPoiEntidad> provincias(){
        return mapPoiEntidadService.findAll();
    }

    @ModelAttribute("provincias")
    public List<MapProvincia> poiSectores(){
        return mapProvinciaService.findAll();
    }

    @ModelAttribute("poi")
    public MapPoi get() {
        return new MapPoi();
    }

}
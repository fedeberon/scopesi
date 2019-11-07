package com.ideaas.web.controller;

import com.ideaas.services.domain.MapPoi;
import com.ideaas.services.service.interfaces.MapPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("poi")
public class PoiController {

    private MapPoiService mapPoiService;

    @Autowired
    public PoiController(MapPoiService mapPoiService) {
        this.mapPoiService = mapPoiService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapPoiService poi = (MapPoiService) mapPoiService.get(id);

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

    @ModelAttribute("poi")
    public MapPoi get() {
        return new MapPoi();
    }

}
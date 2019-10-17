package com.ideaas.web.controller;

import com.ideaas.services.domain.AudEmpresa;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.AudEmpresaService;
import com.ideaas.services.service.interfaces.MapUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by federicoberon on 08/10/2019.
 */

@Controller
@RequestMapping("ubicacion")
public class UbicacionController {


    private MapUbicacionService mapUbicacionService;

    private AudEmpresaService audEmpresaService;

    @Autowired
    public UbicacionController(MapUbicacionService mapUbicacionService, AudEmpresaService audEmpresaService) {
        this.mapUbicacionService = mapUbicacionService;
        this.audEmpresaService = audEmpresaService;
    }

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        model.addAttribute("ubicaciones", mapUbicacionService.findAll(size, page, "id"));

        return "ubicacion/list";

    }

    @RequestMapping("/search")
    public List<MapUbicacion> findAll(@RequestBody MapUbicacionRequest mapUbicacionRequest){
        return mapUbicacionService.findAll(mapUbicacionRequest);
    }


    @ModelAttribute("empresas")
    public List<AudEmpresa> empresas(){
        return audEmpresaService.findAll();
    }

    @ModelAttribute("mapUbicacionRequest")
    public MapUbicacionRequest mapUbicacionRequest(){
        return new MapUbicacionRequest();
    }

}

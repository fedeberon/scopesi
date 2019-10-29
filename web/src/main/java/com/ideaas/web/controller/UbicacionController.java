package com.ideaas.web.controller;

import com.ideaas.services.domain.*;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by federicoberon on 08/10/2019.
 */

@Controller
@RequestMapping("ubicacion")
public class UbicacionController {


    private MapUbicacionService mapUbicacionService;

    private AudEmpresaService audEmpresaService;

    private MapElementoService mapElementoService;

    private MapFormatoService mapFormatoService;

    private MapMedioService mapMedioService;

    private AudLocalidadService audLocalidadService;

    private MapProvinciaService mapProvinciaService;

    @Autowired
    public UbicacionController(MapUbicacionService mapUbicacionService, AudEmpresaService audEmpresaService, MapElementoService mapElementoService, MapFormatoService mapFormatoService, MapMedioService mapMedioService, AudLocalidadService audLocalidadService, MapProvinciaService mapProvinciaService) {
        this.mapUbicacionService = mapUbicacionService;
        this.audEmpresaService = audEmpresaService;
        this.mapElementoService = mapElementoService;
        this.mapFormatoService = mapFormatoService;
        this.mapMedioService = mapMedioService;
        this.audLocalidadService = audLocalidadService;
        this.mapProvinciaService = mapProvinciaService;

    }

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        model.addAttribute("ubicaciones", mapUbicacionService.findAll(size, page, "id"));
        model.addAttribute("page", page);

        return "ubicacion/list";

    }

    @RequestMapping("/search")
    public String findAll(@ModelAttribute MapUbicacionRequest mapUbicacionRequest, Model model){
        model.addAttribute("ubicaciones", mapUbicacionService.findAll(mapUbicacionRequest));

        return "ubicacion/list";
    }

    @ModelAttribute("empresas")
    public List<AudEmpresa> empresas(){
        return audEmpresaService.findAll();
    }

    @ModelAttribute("elementos")
    public List<MapElemento> elementos(){
        return mapElementoService.findAll();
    }

    @ModelAttribute("formatos")
    public List<MapFormato> formatos(){
        return mapFormatoService.findAll();
    }

    @ModelAttribute("medios")
    public List<MapMedio> medios(){
        return mapMedioService.findAll();
    }

    @ModelAttribute("localidades")
    public List<AudLocalidad> localidades(){
        return audLocalidadService.findAll();
    }

    @ModelAttribute("mapUbicacionRequest")
    public MapUbicacionRequest mapUbicacionRequest(){
        return new MapUbicacionRequest();
    }

}

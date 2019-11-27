package com.ideaas.web.controller;

import com.ideaas.services.bean.Wrapper;
import com.ideaas.services.domain.*;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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

    private MapBusService mapBusService;

    private MyObjectService myObjectService;

    @Autowired
    public UbicacionController(MapUbicacionService mapUbicacionService, AudEmpresaService audEmpresaService, MapElementoService mapElementoService, MapFormatoService mapFormatoService, MapMedioService mapMedioService, AudLocalidadService audLocalidadService, MapProvinciaService mapProvinciaService, MapBusService mapBusService) {
        this.mapUbicacionService = mapUbicacionService;
        this.audEmpresaService = audEmpresaService;
        this.mapElementoService = mapElementoService;
        this.mapFormatoService = mapFormatoService;
        this.mapMedioService = mapMedioService;
        this.audLocalidadService = audLocalidadService;
        this.mapProvinciaService = mapProvinciaService;
        this.mapBusService = mapBusService;
    }

    @RequestMapping("/list/whitParameter")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        List<MapUbicacion> result = mapUbicacionService.findAll(size, page, "id");
        model.addAttribute("ubicaciones", result);
        model.addAttribute("page", page);

        return "ubicacion/list";

    }

    @RequestMapping("/list")
    public String findAll(@ModelAttribute MapUbicacionRequest mapUbicacionRequest, Model model){
        model.addAttribute("ubicaciones", mapUbicacionService.findAll(mapUbicacionRequest));
        model.addAttribute("ubicacionRequest", mapUbicacionRequest);

        return "ubicacion/list";
    }

    @RequestMapping("/map")
    public String findAll(@ModelAttribute Wrapper ubicaciones, Model model){
        model.addAttribute("ubicaciones", ubicaciones.getSelectedElements());

        return "ubicacion/map";
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

    @ModelAttribute("provincias")
    public List<MapProvincia> provincias(){
        return mapProvinciaService.findAll();
    }

    @ModelAttribute("mapUbicacionRequest")
    public MapUbicacionRequest mapUbicacionRequest(){
        return new MapUbicacionRequest();
    }

    @ModelAttribute("wrapper")
    public Wrapper wrapper(){
        return new Wrapper();
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("create")
    public String create() {
        return "ubicacion/create";
    }


    @PostMapping("addUbicacion")
    public String save(@ModelAttribute MapUbicacion ubicacion, RedirectAttributes redirectAttributes) {
        ubicacion.setFechaAlta(LocalDateTime.now());
        mapUbicacionService.save(ubicacion);
        redirectAttributes.addAttribute("id", ubicacion.getId());

        return "redirect:/ubicacion/{id}";

    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        MapUbicacion ubicacion = mapUbicacionService.get(id);

        model.addAttribute("ubicaciones", ubicacion);

        return "ubicacion/show";
    }

    @ModelAttribute("ubicacion")
    public MapUbicacion get(){
        return new MapUbicacion();
    }

}
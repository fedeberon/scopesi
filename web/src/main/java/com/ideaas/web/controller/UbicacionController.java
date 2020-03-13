package com.ideaas.web.controller;

import com.ideaas.services.bean.MyObject;
import com.ideaas.services.bean.Wrapper;
import com.ideaas.services.domain.*;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by federicoberon on 08/10/2019.
 */

@Controller
@RequestMapping("ubicacion")
public class UbicacionController {


    private MapUbicacionService mapUbicacionService;

    private MapEmpresaService mapEmpresaService;

    private MapElementoService mapElementoService;

    private MapFormatoService mapFormatoService;

    private MapMedioService mapMedioService;

    private MapLocalidadService mapLocalidadService;

    private MapProvinciaService mapProvinciaService;

    private MapBusService mapBusService;


    @Autowired
    public UbicacionController(MapUbicacionService mapUbicacionService, MapEmpresaService mapEmpresaService, MapElementoService mapElementoService, MapFormatoService mapFormatoService, MapMedioService mapMedioService, MapLocalidadService mapLocalidadService, MapProvinciaService mapProvinciaService, MapBusService mapBusService) {
        this.mapUbicacionService = mapUbicacionService;
        this.mapEmpresaService = mapEmpresaService;
        this.mapElementoService = mapElementoService;
        this.mapFormatoService = mapFormatoService;
        this.mapMedioService = mapMedioService;
        this.mapLocalidadService = mapLocalidadService;
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

    @GetMapping(name = "list")
    public String findAll(@ModelAttribute MapUbicacionRequest mapUbicacionRequest, Model model){
        model.addAttribute("ubicaciones", mapUbicacionService.findAll(mapUbicacionRequest));
        model.addAttribute("ubicacionRequest", mapUbicacionRequest);

        return "ubicacion/list";
    }

    @RequestMapping(value = "search", params = "maps" , method = RequestMethod.POST)
    public String findAll(@ModelAttribute("myWrapper") Wrapper wrapper, Model model){
        model.addAttribute("registros", wrapper.getSelectedElements());
        model.addAttribute("ubicacionRequest", wrapper.getRequest());

        return "ubicacion/map";
    }

    @RequestMapping("list")
    public String list(@ModelAttribute MapUbicacionRequest mapUbicacionRequest, Model model){
        model.addAttribute("ubicaciones", mapUbicacionService.findAll(mapUbicacionRequest));
        model.addAttribute("ubicacionRequest", mapUbicacionRequest);

        return "ubicacion/list";
    }


    @RequestMapping(value = "search", params = "paginate")
    public String listPaginated(@ModelAttribute("myWrapper") Wrapper wrapper, Model model){
        wrapper.getRequest().setPage(wrapper.getPage());
        model.addAttribute("ubicaciones", mapUbicacionService.findAll(wrapper.getRequest()));
        model.addAttribute("ubicacionRequest", wrapper.getRequest());

        return "ubicacion/list";
    }

    @RequestMapping(value = "search", params = "saveList")
    public String saveList(@ModelAttribute Wrapper wrapper, Model model){
        List<Long> ids = wrapper.getSelectedElements().parallelStream().map(MyObject::getId).collect(Collectors.toList());
        MapUbicacionRequest request = wrapper.getRequest();
        request.setIdsSelected(ids);
        model.addAttribute("ubicaciones", mapUbicacionService.saveList(request));
        model.addAttribute("ubicacionRequest", request);

        return "ubicacion/list";
    }

    @ModelAttribute("empresas")
    public List<MapEmpresa> empresas(){
        return mapEmpresaService.findAll();
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
    public List<MapLocalidad> localidades(){
        return mapLocalidadService.findAll();
    }

    @ModelAttribute("provincias")
    public List<MapProvincia> provincias(){
        return mapProvinciaService.findAll();
    }

    @ModelAttribute("mapUbicacionRequest")
    public MapUbicacionRequest mapUbicacionRequest(){
        return new MapUbicacionRequest();
    }

    @ModelAttribute("myWrapper")
    public Wrapper wrapper(){
        return new Wrapper();
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
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

    @PutMapping("editUbicacion")
    public String edit(@ModelAttribute MapUbicacion ubicacion, RedirectAttributes redirectAttributes){
        mapUbicacionService.save(ubicacion);
        redirectAttributes.addAttribute("id", ubicacion.getId());

        return "redirect:/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        MapUbicacion mapUbicacion = mapUbicacionService.get(id);
        model.addAttribute("ubicacion", mapUbicacion);
        return "ubicacion/update";
    }

    @ModelAttribute("ubicacion")
    public MapUbicacion get(){
        return new MapUbicacion();
    }

}
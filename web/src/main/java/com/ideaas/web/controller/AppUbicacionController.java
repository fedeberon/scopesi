package com.ideaas.web.controller;

import com.ideaas.services.bean.Wrapper;
import com.ideaas.services.domain.AppRelevamiento;
import com.ideaas.services.domain.AppUbicacionRelevamiento;
import com.ideaas.services.domain.MapLocalidad;
import com.ideaas.services.domain.MapProvincia;
import com.ideaas.services.service.interfaces.AppRelevamientoService;
import com.ideaas.services.service.interfaces.AppUbicacionRelService;
import com.ideaas.services.service.interfaces.MapLocalidadService;
import com.ideaas.services.service.interfaces.MapProvinciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("appUbicacion")
public class AppUbicacionController {

    private AppUbicacionRelService appUbicacionRelService;
    private AppRelevamientoService appRelevamientoService;
    private MapLocalidadService mapLocalidadService;
    private MapProvinciaService mapProvinciaService;

    public AppUbicacionController(AppUbicacionRelService appUbicacionRelService, AppRelevamientoService appRelevamientoService, MapLocalidadService mapLocalidadService, MapProvinciaService mapProvinciaService) {
        this.appUbicacionRelService = appUbicacionRelService;
        this.appRelevamientoService = appRelevamientoService;
        this.mapLocalidadService = mapLocalidadService;
        this.mapProvinciaService = mapProvinciaService;
    }

    @GetMapping("list")
    public String list(Model model){
        List<AppUbicacionRelevamiento> ubicaciones = appUbicacionRelService.findAll();
        model.addAttribute("ubicaciones", ubicaciones );

        return "appUbicacion/list";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model){
        AppUbicacionRelevamiento ubicacion = appUbicacionRelService.get(id);

        model.addAttribute("appUbicacion", ubicacion);

        return "appUbicacion/show";
    }

    @GetMapping("create")
    public String create() {
        return "appUbicacion/create";
    }

    FieldError emptyNombreRelevamiento = new FieldError(
            "appUbicacionRelevamiento" , "idRelevamiento" , "Debes completar este campo"
    );
    FieldError emptyDireccion = new FieldError(
            "appUbicacionRelevamiento" , "direccion" , "Debes completar este campo"
    );

    @RequestMapping(value = "save" , method = RequestMethod.POST)
    public String save(@ModelAttribute AppUbicacionRelevamiento ubicacion, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(ubicacion.getIdRelevamiento().getId() == null){
            bindingResult.addError(emptyNombreRelevamiento);
        }
        if(ubicacion.getDireccion().isEmpty()){
            bindingResult.addError(emptyDireccion);
        }

        if(bindingResult.hasErrors()) {
            return "appUbicacion/create";
        }

        appUbicacionRelService.save(ubicacion);
        redirectAttributes.addAttribute("id", ubicacion.getId());

        return "redirect:/appUbicacion/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        AppUbicacionRelevamiento ubicacion = appUbicacionRelService.get(id);
        model.addAttribute("updateAppUbicacion", ubicacion);

        return "appUbicacion/update";
    }

    @RequestMapping(value = "saveUpdate" , method = RequestMethod.POST)
    public String update(@ModelAttribute AppUbicacionRelevamiento ubicacion, RedirectAttributes redirectAttributes){
        appUbicacionRelService.save(ubicacion);
        redirectAttributes.addAttribute("id", ubicacion.getId());

        return "redirect:/appUbicacion/{id}";
    }

    @RequestMapping(value = "search", params = "maps" , method = RequestMethod.POST)
    public String findAll(@ModelAttribute("myWrapper") Wrapper ubicaciones, Model model){
        model.addAttribute("registros", ubicaciones.getSelectedElements());

        return "appUbicacion/map";
    }

    @ModelAttribute("appUbicacionRelevamiento")
    public AppUbicacionRelevamiento get(){
        return new AppUbicacionRelevamiento();
    }

    @ModelAttribute("relevamientos")
    public List<AppRelevamiento> relevamientos(){
        return appRelevamientoService.findAll();
    }

    @ModelAttribute("localidades")
    public List<MapLocalidad> localidades(){
        return mapLocalidadService.findByOrderByDescripcionAsc();
    }

    @ModelAttribute("provincias")
    public List<MapProvincia> provincias(){
        return mapProvinciaService.findByOrderByDescripcionAsc();
    }
}

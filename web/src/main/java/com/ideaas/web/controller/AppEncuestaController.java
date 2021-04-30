package com.ideaas.web.controller;

import com.ideaas.services.domain.AppEncuesta;
import com.ideaas.services.service.interfaces.AppEncuestaService;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("encuesta")
public class AppEncuestaController {

    private AppEncuestaService appEncuestaService;

    public AppEncuestaController(AppEncuestaService appEncuestaService) {
        this.appEncuestaService = appEncuestaService;
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model){
        AppEncuesta encuesta = appEncuestaService.get(id);

        model.addAttribute("encuesta", encuesta);

        return "encuesta/show";
    }

    @GetMapping("list")
    public String findAll(Model model) {
        List<AppEncuesta> encuestas = appEncuestaService.findAll();
        model.addAttribute("encuestas", encuestas);

        return "encuesta/list";
    }


    @GetMapping("create")
    public String create() {
        return "encuesta/create";
    }

    FieldError emptyNombreEncuesta = new FieldError(
            "appEncuesta" , "nombreEncuesta" , "Debes completar este campo"
    );
    FieldError emptyLinkPublicacion = new FieldError(
            "appEncuesta" , "linkPublicacion" , "Debes completar este campo"
    );
    FieldError emptyLinkEdicion = new FieldError(
            "appEncuesta" , "linkEdicion" , "Debes completar este campo"
    );
    @RequestMapping(value = "save" , method = RequestMethod.POST)
    public String save(@ModelAttribute AppEncuesta encuesta, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(encuesta.getNombreEncuesta().isEmpty()){
            bindingResult.addError(emptyNombreEncuesta);
        }
        if(encuesta.getLinkPublicacion().isEmpty()){
            bindingResult.addError(emptyLinkPublicacion);
        }
        if(encuesta.getLinkEdicion().isEmpty()){
            bindingResult.addError(emptyLinkEdicion);
        }
        if(bindingResult.hasErrors()) {
            return "encuesta/create";
        }

        appEncuestaService.save(encuesta);
        redirectAttributes.addAttribute("id", encuesta.getId());


        return "redirect:/relevamiento/{id}";

    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        AppEncuesta encuesta = appEncuestaService.get(id);
        model.addAttribute("updateEncuesta", encuesta);

        return "encuesta/update";
    }

    @RequestMapping(value = "saveUpdate" , method = RequestMethod.POST)
    public String update(@ModelAttribute AppEncuesta encuesta, RedirectAttributes redirectAttributes){
        appEncuestaService.save(encuesta);
        redirectAttributes.addAttribute("id", encuesta.getId());

        return "redirect:/encuesta/{id}";
    }


    @ModelAttribute("appEncuesta")
    public AppEncuesta get(){
        return new AppEncuesta();
    }

}

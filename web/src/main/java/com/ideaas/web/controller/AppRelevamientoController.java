package com.ideaas.web.controller;

import com.ideaas.services.domain.AppEncuesta;
import com.ideaas.services.domain.AppRelevamiento;
import com.ideaas.services.domain.Usuario;
import com.ideaas.services.service.interfaces.AppEncuestaService;
import com.ideaas.services.service.interfaces.AppRelevamientoService;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("relevamiento")
public class AppRelevamientoController {

    private AppRelevamientoService appRelevamientoService;

    private AppEncuestaService appEncuestaService;

    private UsuarioService usuarioService;

    public AppRelevamientoController(AppRelevamientoService appRelevamientoService, AppEncuestaService appEncuestaService, UsuarioService usuarioService) {
        this.appRelevamientoService = appRelevamientoService;
        this.appEncuestaService = appEncuestaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("list")
    public String list(Model model){
        List<AppRelevamiento> relevamientos = appRelevamientoService.findAll();
        model.addAttribute("relevamientos", relevamientos );

        return "relevamiento/list";
    }

    @GetMapping("create")
    public String create() {
        return "relevamiento/create";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model){
        AppRelevamiento relevamiento = appRelevamientoService.get(id);

        model.addAttribute("relevamiento", relevamiento);

        return "relevamiento/show";
    }

    FieldError emptyNombreRelevamiento = new FieldError(
            "appRelevamiento" , "nombreRelevamiento" , "Debes completar este campo"
    );
    FieldError emptyUsuario = new FieldError(
            "appRelevamiento" , "usuario" , "Debes seleccionar un inspector"
    );
    FieldError emptyEncuesta = new FieldError(
            "appRelevamiento" , "encuesta" , "Debes seleccionar una encuesta"
    );

    @RequestMapping(value = "save" , method = RequestMethod.POST)
    public String save(@ModelAttribute AppRelevamiento relevamiento, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(relevamiento.getNombreRelevamiento().isEmpty()){
            bindingResult.addError(emptyNombreRelevamiento);
        }
        if(relevamiento.getUsuario().getId() == null){
            bindingResult.addError(emptyUsuario);
        }
        if(relevamiento.getEncuesta().getId() == null){
            bindingResult.addError(emptyEncuesta);
        }

        if(bindingResult.hasErrors()) {
            return "relevamiento/create";
        }

        appRelevamientoService.save(relevamiento);
        redirectAttributes.addAttribute("id", relevamiento.getId());

        return "redirect:/relevamiento/{id}";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        AppRelevamiento relevamiento = appRelevamientoService.get(id);
        model.addAttribute("updateRelevamiento", relevamiento);

        return "relevamiento/update";
    }

    @RequestMapping(value = "saveUpdate" , method = RequestMethod.POST)
    public String update(@ModelAttribute AppRelevamiento relevamiento, RedirectAttributes redirectAttributes){
        appRelevamientoService.save(relevamiento);
        redirectAttributes.addAttribute("id", relevamiento.getId());

        return "redirect:/relevamiento/{id}";
    }

    @ModelAttribute("appRelevamiento")
    public AppRelevamiento get(){
        return new AppRelevamiento();
    }

    @ModelAttribute("encuestas")
    public List<AppEncuesta> encuestas(){
        return appEncuestaService.findAll();
    }

    @ModelAttribute("inspectores")
    public List<Usuario> inspectores(){
        Long inspectorRol = 5L; //5 -> rol de inspector en tipo_usuarios
        return usuarioService.findAllByTipoUsuario(inspectorRol);
    }


//    @RequestMapping("list")
//    public String main(Model model) throws IOException, GeneralSecurityException {
//        model.addAttribute("files", googleFormService.findAllFormsFromGoogleDrive());
//
//        return "encuestas/list";
//    }
}

package com.ideaas.api.restController;

import com.ideaas.services.domain.AppRelevamiento;
import com.ideaas.services.service.interfaces.AppRelevamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/relevamiento")
public class AppRelevamientoRestController {

    private AppRelevamientoService appRelevamientoService;

    @Autowired
    public AppRelevamientoRestController(AppRelevamientoService appRelevamientoService){
        this.appRelevamientoService = appRelevamientoService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findAll/{idUsuario}")
    public List<AppRelevamiento> findAllByIdUsuario(@PathVariable Long idUsuario){
        return appRelevamientoService.findAllByUsuario(idUsuario);
    }
}

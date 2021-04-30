package com.ideaas.api.restController;

import com.ideaas.services.domain.AppUbicacionRelevamiento;
import com.ideaas.services.service.interfaces.AppUbicacionRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appUbicacion")
public class AppUbicacionRestController {

    private AppUbicacionRelService appUbicacionRelService;

    @Autowired
    public AppUbicacionRestController(AppUbicacionRelService appUbicacionRelService) {
        this.appUbicacionRelService = appUbicacionRelService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public AppUbicacionRelevamiento get(@PathVariable Long id){
        return appUbicacionRelService.get(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}/{pageNo}/{sortBy}")
    public List<AppUbicacionRelevamiento> findAll(@PathVariable Integer pageSize, @PathVariable Integer pageNo, @PathVariable String sortBy){
        return appUbicacionRelService.findAll(pageSize, pageNo, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}/{pageNo}")
    public List<AppUbicacionRelevamiento> findAll(@PathVariable Integer pageSize, @PathVariable Integer pageNo){
        return appUbicacionRelService.findAll(pageSize, pageNo, "id");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}")
    public List<AppUbicacionRelevamiento> findAll(@PathVariable Integer pageSize){
        return appUbicacionRelService.findAll(pageSize, 0, "id");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findAll/{idRelevamiento}")
    public List<AppUbicacionRelevamiento> findAllByIdRelevamiento(@PathVariable Long idRelevamiento){
        return appUbicacionRelService.findAllByRelevamiento(idRelevamiento);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AppUbicacionRelevamiento> save(@RequestBody AppUbicacionRelevamiento newAppUbicacion){
        AppUbicacionRelevamiento appUbicacion = appUbicacionRelService.save(newAppUbicacion);

        return new ResponseEntity(appUbicacion, HttpStatus.CREATED);
    }
}

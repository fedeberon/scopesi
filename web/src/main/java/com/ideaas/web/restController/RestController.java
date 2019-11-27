package com.ideaas.web.restController;

import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.MapUbicacionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by federicoberon on 20/11/2019.
 */

@Controller
public class RestController {

    private MapUbicacionService mapUbicacionService;

    private Function<MapUbicacionRequest, Map> service;

    public RestController(MapUbicacionService mapUbicacionService, Function<MapUbicacionRequest, Map> service) {
        this.mapUbicacionService = mapUbicacionService;
        this.service = service;
    }

    @PostMapping("api/filter")
    public @ResponseBody Map filter(@RequestBody MapUbicacionRequest request){
        return service.apply(request);
    }

    @GetMapping("api/ubicacion/{id}")
    public @ResponseBody MapUbicacion get(@PathVariable Long id){
        return mapUbicacionService.get(id);
    }

}

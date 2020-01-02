package com.ideaas.web.restController;

import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.MapUbicacionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by federicoberon on 20/11/2019.
 */

@RestController
public class ApiRestController {

    private MapUbicacionService mapUbicacionService;

    private Function<MapUbicacionRequest, Map> service;

    public ApiRestController(MapUbicacionService mapUbicacionService, Function<MapUbicacionRequest, Map> service) {
        this.mapUbicacionService = mapUbicacionService;
        this.service = service;
    }

    @PostMapping("api/filter")
    @ResponseBody
    public Map filter(@RequestBody MapUbicacionRequest request){
        return service.apply(request);
    }

    @GetMapping("api/ubicacion/{id}")
    public @ResponseBody MapUbicacion get(@PathVariable Long id){
        return mapUbicacionService.get(id);
    }



    @PutMapping("api/ubicacion")
    public ResponseEntity<MapUbicacion> update(@RequestBody MapUbicacionRequest request){
        mapUbicacionService.saveLatLong(request);

        return new ResponseEntity(new HttpHeaders(), HttpStatus.OK);
    }


}

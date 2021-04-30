package com.ideaas.web.restController;

import com.ideaas.services.bean.MyObject;
import com.ideaas.services.domain.AppUbicacionRelevamiento;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.AppUbicacionRelService;
import com.ideaas.services.service.interfaces.MapUbicacionService;
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

    private AppUbicacionRelService appUbicacionRelService;

    private Function<MapUbicacionRequest, Map> service;

    public ApiRestController(MapUbicacionService mapUbicacionService, AppUbicacionRelService appUbicacionRelService, Function<MapUbicacionRequest, Map> service) {
        this.mapUbicacionService = mapUbicacionService;
        this.appUbicacionRelService = appUbicacionRelService;
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



    @PostMapping("api/updateCoordenadas")
    public ResponseEntity<MapUbicacion> update(@RequestBody MapUbicacionRequest request){
        mapUbicacionService.saveLatLong(request);
        MapUbicacion ubicacion = mapUbicacionService.get(request.getId());

        return new ResponseEntity(ubicacion, HttpStatus.OK);
    }

    @PostMapping("api/updateCoordenadasApp")
    public ResponseEntity<MyObject> update(@RequestBody MyObject object){
        appUbicacionRelService.saveLatLong(object);

        return new ResponseEntity(object, HttpStatus.OK);
    }

    @PostMapping("api/savePolygon")
    public ResponseEntity<MapUbicacion> savePolygon(@RequestBody MapUbicacionRequest request){
        mapUbicacionService.savePolygon(request);
        MapUbicacion ubicacion = mapUbicacionService.get(request.getId());

        return new ResponseEntity(ubicacion, HttpStatus.OK);
    }
}

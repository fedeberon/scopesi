package com.ideaas.web.restController;

import com.ideaas.services.request.MapUbicacionRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by federicoberon on 20/11/2019.
 */

@Controller
public class RestController {

    private Function<MapUbicacionRequest, Map> service;

    public RestController(Function<MapUbicacionRequest, Map> service) {
        this.service = service;
    }

    @PostMapping("api/filter")
    public @ResponseBody Map filter(@RequestBody MapUbicacionRequest request){
        return service.apply(request);
    }

}

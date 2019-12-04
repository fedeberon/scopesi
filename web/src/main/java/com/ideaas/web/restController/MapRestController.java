package com.ideaas.web.restController;

import com.google.maps.model.GeocodingResult;
import com.ideaas.services.service.interfaces.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by federicoberon on 04/12/2019.
 */
@RestController
public class MapRestController {

    private GoogleMapsService googleMapsService;

    @Autowired
    public MapRestController(GoogleMapsService googleMapsService) {
        this.googleMapsService = googleMapsService;
    }

    @GetMapping("map/searchCoordinatesByAdress")
    public ResponseEntity locate(@RequestParam String address) {
        GeocodingResult[] results = googleMapsService.getByAddress(address);
        return new ResponseEntity<>(results[0].geometry, HttpStatus.OK);
    }
}

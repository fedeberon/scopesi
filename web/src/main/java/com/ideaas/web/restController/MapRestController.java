package com.ideaas.web.restController;

import com.google.maps.model.GeocodingResult;
import com.ideaas.services.domain.MapHeatmap;
import com.ideaas.services.request.HeatMapRequest;
import com.ideaas.services.service.interfaces.GoogleMapsService;
import com.ideaas.services.service.interfaces.MapHeatmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by federicoberon on 04/12/2019.
 */
@RestController
public class MapRestController {

    private GoogleMapsService googleMapsService;

    private MapHeatmapService mapHeatmapService;

    @Autowired
    public MapRestController(GoogleMapsService googleMapsService , MapHeatmapService mapHeatmapService) {
        this.googleMapsService = googleMapsService;
        this.mapHeatmapService = mapHeatmapService;
    }

    @GetMapping("map/searchCoordinatesByAdress")
    public ResponseEntity locate(@RequestParam String address) {
        GeocodingResult[] results = googleMapsService.getByAddress(address);
        return new ResponseEntity<>(results[0].geometry, HttpStatus.OK);
    }

    @GetMapping("heatMap/list")
    public List<MapHeatmap> findAll(@RequestBody HeatMapRequest request){
        return mapHeatmapService.findAll();
    }
}

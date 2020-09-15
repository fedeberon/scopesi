package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MapUbicacionService {

    MapUbicacion get(Long id);

    MapUbicacion save(MapUbicacion mapUbicacion);

    Optional<MapUbicacion> findById(Long id);

    List<MapUbicacion> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<MapUbicacion> findAll(MapUbicacionRequest mapUbicacionRequest);

    List<MapUbicacion> saveList(MapUbicacionRequest mapUbicacionRequest);

    void saveLatLong(MapUbicacionRequest request);

    void savePolygon(MapUbicacionRequest request);

}

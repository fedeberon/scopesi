package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;

import java.util.List;

public interface MapUbicacionService {

    MapUbicacion get(Long id);

    MapUbicacion save(MapUbicacion mapUbicacion);

    List<MapUbicacion> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<MapUbicacion> findAll(MapUbicacionRequest mapUbicacionRequest);
}

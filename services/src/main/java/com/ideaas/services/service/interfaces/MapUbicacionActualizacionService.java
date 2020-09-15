package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.MapUbicacionActualizacion;
import com.ideaas.services.domain.MapUbicacionActualizacionPK;

import java.util.List;

public interface MapUbicacionActualizacionService {

    MapUbicacionActualizacion get(MapUbicacionActualizacionPK id);

    MapUbicacionActualizacion save(MapUbicacionActualizacion mapUbicacionActualizacion);

    List<MapUbicacionActualizacion> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<MapUbicacionActualizacion> findAll();
}

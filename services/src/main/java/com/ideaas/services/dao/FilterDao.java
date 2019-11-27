package com.ideaas.services.dao;

import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;

import java.util.List;
import java.util.Map;

public interface FilterDao {
    List<MapUbicacion> find(MapUbicacionRequest request);

    List<MapUbicacion> filterSearchUbicacion(Map<String, String> clauses);
}

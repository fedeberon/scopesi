package com.ideaas.services.dao;

import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;

import java.util.List;

public interface FilterDao {
    List<MapUbicacion> find(MapUbicacionRequest request);
}

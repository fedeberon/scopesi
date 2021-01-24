package com.ideaas.services.dao;

import com.ideaas.services.domain.MapPoi;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.domain.MapUbicacionActEspecial;
import com.ideaas.services.domain.MapUbicacionActualizacion;
import com.ideaas.services.request.MapPoiRequest;
import com.ideaas.services.request.MapUbiActEspecialRequest;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.request.UbicacionActualizacionRequest;

import java.util.List;
import java.util.Map;

public interface FilterDao {
    List<MapUbicacion> find(MapUbicacionRequest request);

    List<MapUbicacion> filterSearchUbicacion(Map<String, String> clauses);

    List<MapUbicacionActualizacion> find(UbicacionActualizacionRequest ubicacionActualizacionRequest);

    List<MapUbicacionActEspecial> find(MapUbiActEspecialRequest mapUbiActEspecialRequest);

    List<MapPoi> find(MapPoiRequest mapPoiRequest);
}

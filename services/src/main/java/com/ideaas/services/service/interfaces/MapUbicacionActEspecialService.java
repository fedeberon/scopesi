package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.MapUbicacionActEspecial;
import com.ideaas.services.domain.MapUbicacionActEspecialPK;
import java.util.List;

public interface MapUbicacionActEspecialService {

    MapUbicacionActEspecial get(MapUbicacionActEspecialPK id);

    MapUbicacionActEspecial save(MapUbicacionActEspecial mapUbicacionActEspecial);

    List<MapUbicacionActEspecial> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<MapUbicacionActEspecial> findAll();
}

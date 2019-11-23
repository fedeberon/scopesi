package com.ideaas.services.service;

import com.ideaas.services.dao.FilterDao;
import com.ideaas.services.domain.AudEmpresa;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.FilterSearchUbicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by federicoberon on 21/11/2019.
 */

@Service
public class FilterSearchUbicacionImpl implements FilterSearchUbicacion {


    private FilterDao dao;

    @Autowired
    public FilterSearchUbicacionImpl(FilterDao dao) {
        this.dao = dao;
    }



    public Map searchFilterUbicacion(MapUbicacionRequest request){
        Map clauses = new HashMap();
        clauses.put("audEmpresa.descripcion", request.getAudEmpresa());
        clauses.put("mapElemento.descripcion", request.getMapElemento());
        clauses.put("mapProvincia.descripcion", request.getMapProvincia());
        clauses.put("mapFormato.descripcion", request.getMapFormato());
        clauses.put("audLocalidad.descripcion", request.getAudLocalidad());
        clauses.put("mapMedio.descripcion", request.getMapMedio());
        List<MapUbicacion> ubicaciones = dao.filterSearchUbicacion(clauses);

        List<String> empresas =
                ubicaciones.stream().filter(line -> line.getAudEmpresa().getDescripcion().equals(request.getAudEmpresa())).collect(Collectors.toList());

        return clauses;
    }
}

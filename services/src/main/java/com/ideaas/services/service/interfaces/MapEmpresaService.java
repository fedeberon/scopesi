package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.MapEmpresa;

import java.util.List;

public interface MapEmpresaService {

    MapEmpresa get(Long id);

    MapEmpresa save(MapEmpresa mapEmpresa);

    List<MapEmpresa> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<MapEmpresa> findAll();
}

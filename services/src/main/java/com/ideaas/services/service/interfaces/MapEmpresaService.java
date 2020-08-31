package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.MapEmpresa;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface MapEmpresaService {

    MapEmpresa get(Long id);

    MapEmpresa save(MapEmpresa mapEmpresa);

    List<MapEmpresa> findAll();

    List<MapEmpresa> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<MapEmpresa> findByOrderByDescripcionAsc();
}

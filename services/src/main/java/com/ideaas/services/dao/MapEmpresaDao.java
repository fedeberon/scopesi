package com.ideaas.services.dao;

import com.ideaas.services.domain.MapEmpresa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapEmpresaDao extends PagingAndSortingRepository<MapEmpresa, Long> {

    List<MapEmpresa> findByOrderByDescripcionAsc();
}

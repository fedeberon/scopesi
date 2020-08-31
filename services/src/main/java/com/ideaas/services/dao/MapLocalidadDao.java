package com.ideaas.services.dao;

import com.ideaas.services.domain.MapLocalidad;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MapLocalidadDao extends PagingAndSortingRepository<MapLocalidad, Long> {

    List<MapLocalidad> findByOrderByDescripcionAsc();
}

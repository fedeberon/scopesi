package com.ideaas.services.dao;

import com.ideaas.services.domain.MapMedio;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MapMedioDao extends PagingAndSortingRepository<MapMedio, Long> {

    List<MapMedio> findByOrderByDescripcionAsc();
}

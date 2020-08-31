package com.ideaas.services.dao;


import com.ideaas.services.domain.MapElemento;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapElementoDao extends PagingAndSortingRepository<MapElemento, Long> {

    List<MapElemento> findByOrderByDescripcionAsc();
}

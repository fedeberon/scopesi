package com.ideaas.services.dao;


import com.ideaas.services.domain.MapElemento;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapElementoDao extends PagingAndSortingRepository<MapElemento, Long> {
}

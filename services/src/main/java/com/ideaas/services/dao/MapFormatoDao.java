package com.ideaas.services.dao;

import com.ideaas.services.domain.MapFormato;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapFormatoDao extends PagingAndSortingRepository<MapFormato, Long> {

    List<MapFormato> findByOrderByDescripcionAsc();
}

package com.ideaas.services.dao;

import com.ideaas.services.domain.MapFormato;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapFormatoDao extends PagingAndSortingRepository<MapFormato, Long> {
}

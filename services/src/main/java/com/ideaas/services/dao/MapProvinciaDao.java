package com.ideaas.services.dao;

import com.ideaas.services.domain.MapProvincia;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapProvinciaDao extends PagingAndSortingRepository<MapProvincia, Long> {
}

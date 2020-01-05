package com.ideaas.services.dao;

import com.ideaas.services.domain.MapUbicacion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MapUbicacionDao extends PagingAndSortingRepository<MapUbicacion, Long> {


}

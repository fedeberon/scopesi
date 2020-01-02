package com.ideaas.services.dao;

import com.ideaas.services.domain.MapUbicacion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MapUbicacionDao extends PagingAndSortingRepository<MapUbicacion, Long> {

    @Modifying
    @Query("update MapUbicacion u set u.id = ?1, u.latitud = ?2 where u.longitud = ?3")
    void saveLatLong(Long id, BigDecimal lat, BigDecimal lng);

}

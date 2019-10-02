package com.ideaas.services.dao;

import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapUbicacionDao extends PagingAndSortingRepository<MapUbicacion, Long> {

    @Query("select u from MapUbicacion u where u.id = :#{#request.id} or u.audEmpresa.descripcion = :#{#request.audEmpresa.descripcion} ")
    List<MapUbicacion> findAllBy(@Param("request") MapUbicacionRequest request);

}

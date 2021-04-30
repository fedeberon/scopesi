package com.ideaas.services.dao;

import com.ideaas.services.domain.AppUbicacionRelevamiento;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AppUbicacionRelDao extends PagingAndSortingRepository<AppUbicacionRelevamiento, Long> {

    List<AppUbicacionRelevamiento> findAllByIdRelevamiento_Id(Long idRelevamiento);
}

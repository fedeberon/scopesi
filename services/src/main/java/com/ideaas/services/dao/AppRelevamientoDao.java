package com.ideaas.services.dao;

import com.ideaas.services.domain.AppRelevamiento;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AppRelevamientoDao extends PagingAndSortingRepository<AppRelevamiento, Long> {

    List<AppRelevamiento> findAllByUsuario(Long idUsuario);
}

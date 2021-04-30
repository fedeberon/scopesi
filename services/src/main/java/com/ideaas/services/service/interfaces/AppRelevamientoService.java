package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.AppRelevamiento;

import java.util.List;

public interface AppRelevamientoService {

    AppRelevamiento get(Long id);

    AppRelevamiento save(AppRelevamiento appRelevamiento);

    List<AppRelevamiento> findAll();

    List<AppRelevamiento> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<AppRelevamiento> findAllByUsuario(Long idUsuario);
}

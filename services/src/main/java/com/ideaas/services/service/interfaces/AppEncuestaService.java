package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.AppEncuesta;

import java.util.List;

public interface AppEncuestaService {

    AppEncuesta get(Long id);

    AppEncuesta save(AppEncuesta appEncuesta);

    List<AppEncuesta> findAll();

    List<AppEncuesta> findAll(Integer pageSize, Integer pageNo, String sortBy);
}

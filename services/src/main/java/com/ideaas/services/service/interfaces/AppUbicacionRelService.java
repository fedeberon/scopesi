package com.ideaas.services.service.interfaces;

import com.ideaas.services.bean.MyObject;
import com.ideaas.services.domain.AppUbicacionRelevamiento;

import java.util.List;

public interface AppUbicacionRelService {

    AppUbicacionRelevamiento get(Long id);

    AppUbicacionRelevamiento save(AppUbicacionRelevamiento appUbicacionRelevamiento);

    List<AppUbicacionRelevamiento> findAll();

    List<AppUbicacionRelevamiento> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<AppUbicacionRelevamiento> findAllByRelevamiento(Long idRelevamiento);

    void saveLatLong(MyObject object);
}

package com.ideaas.services.service;

import com.ideaas.services.dao.MapUbicacionDao;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.MapUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapUbicacionServiceImpl implements MapUbicacionService {

    private MapUbicacionDao dao;

    @Autowired
    public MapUbicacionServiceImpl(MapUbicacionDao dao) {
        this.dao = dao;
    }

    @Override
    public MapUbicacion get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public MapUbicacion save(MapUbicacion mapUbicacion) {
        return dao.save(mapUbicacion);
    }

    @Override
    public List<MapUbicacion> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapUbicacion> mapUbicaciones = dao.findAll(paging);

        return mapUbicaciones.getContent();
    }

    @Override
    public List<MapUbicacion> findAll(MapUbicacionRequest mapUbicacionRequest) {
        return dao.findAllBy(mapUbicacionRequest);
    }

}

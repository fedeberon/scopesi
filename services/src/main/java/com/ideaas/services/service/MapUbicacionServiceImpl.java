package com.ideaas.services.service;

import com.ideaas.services.dao.FilterDao;
import com.ideaas.services.dao.MapUbicacionDao;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.FileService;
import com.ideaas.services.service.interfaces.MapUbicacionService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapUbicacionServiceImpl implements MapUbicacionService{

    private MapUbicacionDao dao;

    private FilterDao filterDao;

    private FileService fileService;


    @Autowired
    public MapUbicacionServiceImpl(MapUbicacionDao dao, FilterDao filterDao, FileService fileService) {
        this.dao = dao;
        this.filterDao = filterDao;
        this.fileService = fileService;
    }

    @Override
    public MapUbicacion get(Long id) {
        MapUbicacion  ubicacion = dao.getOne(id);
        ubicacion.setImages(fileService.readFiles(ubicacion));

        return ubicacion;
    }

    @Override
    public MapUbicacion save(MapUbicacion mapUbicacion) {
        return dao.save(mapUbicacion);
    }

    @Override
    public List<MapUbicacion> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapUbicacion> mapUbicaciones = dao.findAll(paging);
        mapUbicaciones.forEach(mapUbicacion -> mapUbicacion.setImages(fileService.readFiles(mapUbicacion)));

        return mapUbicaciones.getContent();
    }

    @Override
    public List<MapUbicacion> findAll(MapUbicacionRequest mapUbicacionRequest) {
        return filterDao.find(mapUbicacionRequest);
    }

}

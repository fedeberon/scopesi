package com.ideaas.services.service;

import com.ideaas.services.dao.FilterDao;
import com.ideaas.services.dao.MapUbicacionDao;
import com.ideaas.services.domain.*;
import com.ideaas.services.request.MapUbicacionRequest;
import com.ideaas.services.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MapUbicacionServiceImpl implements MapUbicacionService{

    private MapUbicacionDao dao;

    private FilterDao filterDao;

    private FileService fileService;

    private MapEmpresaService mapEmpresaService;

    private MapElementoService mapElementoService;

    private MapFormatoService mapFormatoService;

    private MapMedioService mapMedioService;

    private MapProvinciaService mapProvinciaService;

    private MapLocalidadService mapLocalidadService;

    @Autowired
    public MapUbicacionServiceImpl(MapUbicacionDao dao, FilterDao filterDao, FileService fileService, MapEmpresaService mapEmpresaService, MapElementoService mapElementoService, MapFormatoService mapFormatoService, MapMedioService mapMedioService, MapProvinciaService mapProvinciaService, MapLocalidadService mapLocalidadService) {
        this.dao = dao;
        this.filterDao = filterDao;
        this.fileService = fileService;
        this.mapEmpresaService = mapEmpresaService;
        this.mapElementoService = mapElementoService;
        this.mapFormatoService = mapFormatoService;
        this.mapMedioService = mapMedioService;
        this.mapProvinciaService = mapProvinciaService;
        this.mapLocalidadService = mapLocalidadService;
    }

    @Override
    public MapUbicacion get(Long id) {
        MapUbicacion  ubicacion = dao.findById(id).get();
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

    @Override
    public List<MapUbicacion> saveList(MapUbicacionRequest request) {
        List<MapUbicacion> results = filterDao.find(request);

        if(Objects.nonNull(request.getIdEmpresa())){
            MapEmpresa empresa = mapEmpresaService.get(request.getIdEmpresa());
            results.forEach(mapUbicacion -> mapUbicacion.setMapEmpresa(empresa));
        }

        if(Objects.nonNull(request.getIdElemento())){
            MapElemento elemento = mapElementoService.get(request.getIdElemento());
            results.forEach(mapUbicacion -> mapUbicacion.setMapElemento(elemento));
        }

        if(Objects.nonNull(request.getIdFormato())){
            MapFormato formato = mapFormatoService.get(request.getIdFormato());
            results.forEach(mapUbicacion -> mapUbicacion.setMapFormato(formato));
        }

        if(Objects.nonNull(request.getIdMedio())){
            MapMedio medio = mapMedioService.get(request.getIdMedio());
            results.forEach(mapUbicacion -> mapUbicacion.setMapMedio(medio));
        }

        if(Objects.nonNull(request.getMapProvincia())){
            MapProvincia provincia = mapProvinciaService.get(request.getIdProvincia());
            results.forEach(mapUbicacion -> mapUbicacion.setMapProvincia(provincia));
        }

        if(Objects.nonNull(request.getIdLocalidad())){
            MapLocalidad localidad = mapLocalidadService.get(request.getIdLocalidad());
            results.forEach(mapUbicacion -> mapUbicacion.setMapLocalidad(localidad));
        }



        dao.saveAll(results);

        return results;
    }

}

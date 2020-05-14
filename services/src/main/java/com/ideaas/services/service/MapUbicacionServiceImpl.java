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

import java.math.BigDecimal;
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

    private MapUbicacionAlturaService mapUbicacionAlturaService;

    private MapUbicacionVisibilidadService mapUbicacionVisibilidadService;

    private GoogleMapsService googleMapsService;

    @Autowired
    public MapUbicacionServiceImpl(MapUbicacionDao dao, FilterDao filterDao, FileService fileService, MapEmpresaService mapEmpresaService, MapElementoService mapElementoService, MapFormatoService mapFormatoService, MapMedioService mapMedioService, MapProvinciaService mapProvinciaService, MapLocalidadService mapLocalidadService, MapUbicacionAlturaService mapUbicacionAlturaService, MapUbicacionVisibilidadService mapUbicacionVisibilidadService,GoogleMapsService googleMapsService) {
        this.dao = dao;
        this.filterDao = filterDao;
        this.fileService = fileService;
        this.mapEmpresaService = mapEmpresaService;
        this.mapElementoService = mapElementoService;
        this.mapFormatoService = mapFormatoService;
        this.mapMedioService = mapMedioService;
        this.mapProvinciaService = mapProvinciaService;
        this.mapLocalidadService = mapLocalidadService;
        this.mapUbicacionAlturaService = mapUbicacionAlturaService;
        this.mapUbicacionVisibilidadService = mapUbicacionVisibilidadService;
        this.googleMapsService = googleMapsService;
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

        if(Objects.nonNull(request.getIdEmpresa()) && !request.getIdEmpresa().equals(-1l)){
            MapEmpresa empresa = mapEmpresaService.get(request.getIdEmpresa());
            results.forEach(mapUbicacion -> mapUbicacion.setMapEmpresa(empresa));
        }

        if(Objects.nonNull(request.getIdElemento()) && !request.getIdElemento().equals(-1l)){
            MapElemento elemento = mapElementoService.get(request.getIdElemento());
            results.forEach(mapUbicacion -> mapUbicacion.setMapElemento(elemento));
        }

        if(Objects.nonNull(request.getIdFormato()) && !request.getIdFormato().equals(-1l)){
            MapFormato formato = mapFormatoService.get(request.getIdFormato());
            results.forEach(mapUbicacion -> mapUbicacion.setMapFormato(formato));
        }

        if(Objects.nonNull(request.getIdMedio()) && !request.getIdMedio().equals(-1l)){
            MapMedio medio = mapMedioService.get(request.getIdMedio());
            results.forEach(mapUbicacion -> mapUbicacion.setMapMedio(medio));
        }

        if(Objects.nonNull(request.getMapProvincia()) && !request.getIdProvincia().equals(-1l)){
            MapProvincia provincia = mapProvinciaService.get(request.getIdProvincia());
            results.forEach(mapUbicacion -> mapUbicacion.setMapProvincia(provincia));
        }

        if(Objects.nonNull(request.getIdLocalidad()) && !request.getIdLocalidad().equals(-1l)){
            MapLocalidad localidad = mapLocalidadService.get(request.getIdLocalidad());
            results.forEach(mapUbicacion -> mapUbicacion.setMapLocalidad(localidad));
        }

        if(Objects.nonNull(request.getIdAltura()) && !request.getIdAltura().equals(-1l)){
            MapUbicacionAltura altura = mapUbicacionAlturaService.get(request.getIdAltura());
            results.forEach(mapUbicacion -> mapUbicacion.setMapUbicacionAltura(altura));
        }

        if(Objects.nonNull(request.getIdVisibilidad()) && !request.getIdVisibilidad().equals(-1l)){
            MapUbicacionVisibilidad visibilidad = mapUbicacionVisibilidadService.get(request.getIdVisibilidad());
            results.forEach(mapUbicacion -> mapUbicacion.setMapUbicacionVisibilidad(visibilidad));
        }

        if(Objects.nonNull(request.getMetrosContactoRequest()) && request.getMetrosContactoRequest() instanceof Long){
            results.forEach(mapUbicacion -> mapUbicacion.setMetrosContacto(request.getMetrosContactoRequest()));
        }

        if(Objects.nonNull(request.getCoeficienteRequest()) && request.getCoeficienteRequest() instanceof BigDecimal){
            results.forEach(mapUbicacion -> mapUbicacion.setCoeficiente(request.getCoeficienteRequest()));
        }


        dao.saveAll(results);

        return results;
    }

    public void saveLatLong(MapUbicacionRequest request) {
        MapUbicacion ubicacion = this.get(request.getId());
        String address =  googleMapsService.locate(request.getLatitud(), request.getLongitud());
        ubicacion.setLatitud(request.getLatitud());
        ubicacion.setLongitud(request.getLongitud());
        save(ubicacion);
    }

    public void savePolygon(MapUbicacionRequest request) {
        MapUbicacion ubicacion = this.get(request.getId());
        ubicacion.setPolygonLatLong(request.getPolygonLatLong());
        save(ubicacion);
    }
}

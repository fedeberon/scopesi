package com.ideaas.services.service;

import com.ideaas.services.dao.MapLocalidadDao;
import com.ideaas.services.domain.MapLocalidad;
import com.ideaas.services.service.interfaces.MapLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MapLocalidadServiceImpl implements MapLocalidadService {

    private MapLocalidadDao dao;

    @Autowired
    public MapLocalidadServiceImpl(MapLocalidadDao dao) {
        this.dao = dao;
    }

    @Override
    public MapLocalidad get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public MapLocalidad save(MapLocalidad mapLocalidad) {
        return dao.save(mapLocalidad);
    }

    @Override
    public List<MapLocalidad> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapLocalidad> mapLocalidades = dao.findAll(paging);

        return mapLocalidades.getContent();
    }

    @Override
    public List<MapLocalidad> findAll() {
        Iterable<MapLocalidad> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<MapLocalidad> findByOrderByDescripcionAsc(){

        Iterable<MapLocalidad> iterator = dao.findByOrderByDescripcionAsc();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());

    }
}

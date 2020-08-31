package com.ideaas.services.service;

import com.ideaas.services.dao.MapElementoDao;
import com.ideaas.services.domain.MapElemento;
import com.ideaas.services.service.interfaces.MapElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MapElementoServiceImpl implements MapElementoService {

    private MapElementoDao dao;

    @Autowired
    public MapElementoServiceImpl(MapElementoDao dao) {
        this.dao = dao;
    }

    @Override
    public MapElemento get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public MapElemento save(MapElemento mapElemento) {
        return dao.save(mapElemento);
    }

    @Override
    public List<MapElemento> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapElemento> mapElemento = dao.findAll(paging);

        return mapElemento.getContent();
    }

    @Override
    public List<MapElemento> findAll() throws EntityNotFoundException {
        Iterable<MapElemento> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<MapElemento> findByOrderByDescripcionAsc(){

        Iterable<MapElemento> iterator = dao.findByOrderByDescripcionAsc();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());

    }
}

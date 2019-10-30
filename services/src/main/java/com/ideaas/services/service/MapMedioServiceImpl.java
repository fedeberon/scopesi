package com.ideaas.services.service;

import com.ideaas.services.dao.MapMedioDao;
import com.ideaas.services.domain.MapMedio;
import com.ideaas.services.service.interfaces.MapMedioService;
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
public class MapMedioServiceImpl implements MapMedioService {

    private MapMedioDao dao;

    @Autowired
    public MapMedioServiceImpl(MapMedioDao dao) {
        this.dao = dao;
    }

    @Override
    public MapMedio get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public MapMedio save(MapMedio mapMedio) {
        return dao.save(mapMedio);
    }

    @Override
    public List<MapMedio> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapMedio> mapMedios = dao.findAll(paging);

        return mapMedios.getContent();
    }

    @Override
    public List<MapMedio> findAll() {
        Iterable<MapMedio> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }
}

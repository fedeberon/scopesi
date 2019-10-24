package com.ideaas.services.service;

import com.ideaas.services.dao.MapProvinciaDao;
import com.ideaas.services.domain.MapProvincia;
import com.ideaas.services.service.interfaces.MapProvinciaService;
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
public class MapProvinciaServiceImpl implements MapProvinciaService {

    private MapProvinciaDao dao;

    @Autowired
    public MapProvinciaServiceImpl(MapProvinciaDao dao) {
        this.dao = dao;
    }

    @Override
    public MapProvincia get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public MapProvincia save(MapProvincia mapProvincia) {
        return dao.save(mapProvincia);
    }

    @Override
    public List<MapProvincia> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapProvincia> mapProvincias = dao.findAll(paging);

        return mapProvincias.getContent();
    }

    @Override
    public List<MapProvincia> findAll() {
        Iterable<MapProvincia> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }
}

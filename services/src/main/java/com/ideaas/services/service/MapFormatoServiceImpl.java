package com.ideaas.services.service;

import com.ideaas.services.dao.MapFormatoDao;
import com.ideaas.services.domain.MapFormato;
import com.ideaas.services.service.interfaces.MapFormatoService;
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
public class MapFormatoServiceImpl implements MapFormatoService {

    private MapFormatoDao dao;

    @Autowired
    public MapFormatoServiceImpl(MapFormatoDao dao) {
        this.dao = dao;
    }

    @Override
    public MapFormato get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public MapFormato save(MapFormato mapFormato) {
        return dao.save(mapFormato);
    }

    @Override
    public List<MapFormato> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapFormato> mapFormato = dao.findAll(paging);

        return mapFormato.getContent();
    }

    @Override
    public List<MapFormato> findAll() {
        Iterable<MapFormato> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }
}

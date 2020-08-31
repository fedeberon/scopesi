package com.ideaas.services.service;

import com.ideaas.services.dao.MapEmpresaDao;
import com.ideaas.services.domain.MapEmpresa;
import com.ideaas.services.service.interfaces.MapEmpresaService;
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
public class MapEmpresaServiceImpl implements MapEmpresaService {

    private MapEmpresaDao dao;

    @Autowired
    public MapEmpresaServiceImpl(MapEmpresaDao dao) {
        this.dao = dao;
    }

    @Override
    public MapEmpresa get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public MapEmpresa save(MapEmpresa mapEmpresa) {
        return dao.save(mapEmpresa);
    }

    @Override
    public List<MapEmpresa> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapEmpresa> mapEmpresas = dao.findAll(paging);

        return mapEmpresas.getContent();
    }

    @Override
    public List<MapEmpresa> findAll() {
        Iterable<MapEmpresa> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<MapEmpresa> findByOrderByDescripcionAsc(){

        Iterable<MapEmpresa> iterator = dao.findByOrderByDescripcionAsc();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());

    }
}

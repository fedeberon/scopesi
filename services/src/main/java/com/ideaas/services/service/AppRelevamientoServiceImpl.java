package com.ideaas.services.service;

import com.ideaas.services.dao.AppRelevamientoDao;
import com.ideaas.services.domain.AppRelevamiento;
import com.ideaas.services.service.interfaces.AppRelevamientoService;
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
public class AppRelevamientoServiceImpl implements AppRelevamientoService {

    private AppRelevamientoDao dao;

    @Autowired
    public AppRelevamientoServiceImpl(AppRelevamientoDao dao) {
        this.dao = dao;
    }

    @Override
    public AppRelevamiento get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public AppRelevamiento save(AppRelevamiento appRelevamiento) {
        return dao.save(appRelevamiento);
    }

    @Override
    public List<AppRelevamiento> findAll() {
        Iterable<AppRelevamiento> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppRelevamiento> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<AppRelevamiento> appRelevamientos = dao.findAll(paging);

        return appRelevamientos.getContent();
    }

    @Override
    public List<AppRelevamiento> findAllByUsuario(Long idUsuario) {
        Iterable<AppRelevamiento> iterator = dao.findAllByUsuario(idUsuario);

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }
}

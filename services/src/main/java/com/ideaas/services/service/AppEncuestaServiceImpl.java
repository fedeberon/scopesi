package com.ideaas.services.service;

import com.ideaas.services.dao.AppEncuestaDao;
import com.ideaas.services.domain.AppEncuesta;
import com.ideaas.services.service.interfaces.AppEncuestaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppEncuestaServiceImpl implements AppEncuestaService {

    private AppEncuestaDao dao;

    private AppEncuestaServiceImpl(AppEncuestaDao dao){
        this.dao = dao;
    }

    @Override
    public AppEncuesta get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public AppEncuesta save(AppEncuesta appEncuesta) {
        return dao.save(appEncuesta);
    }

    @Override
    public List<AppEncuesta> findAll() {
        Iterable<AppEncuesta> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppEncuesta> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<AppEncuesta> appEncuestas = dao.findAll(paging);

        return appEncuestas.getContent();
    }
}

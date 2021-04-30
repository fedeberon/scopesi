package com.ideaas.services.service;

import com.ideaas.services.bean.MyObject;
import com.ideaas.services.dao.AppUbicacionRelDao;
import com.ideaas.services.domain.AppUbicacionRelevamiento;
import com.ideaas.services.service.interfaces.AppUbicacionRelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppUbicacionRelServiceImpl implements AppUbicacionRelService {

    private AppUbicacionRelDao dao;

    public AppUbicacionRelServiceImpl(AppUbicacionRelDao dao) {
        this.dao = dao;
    }

    @Override
    public AppUbicacionRelevamiento get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public AppUbicacionRelevamiento save(AppUbicacionRelevamiento appUbicacionRelevamiento) {
        return dao.save(appUbicacionRelevamiento);
    }

    @Override
    public List<AppUbicacionRelevamiento> findAll() {
        Iterable<AppUbicacionRelevamiento> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppUbicacionRelevamiento> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<AppUbicacionRelevamiento> appUbicacionesRelevamientos = dao.findAll(paging);

        return appUbicacionesRelevamientos.getContent();
    }

    @Override
    public List<AppUbicacionRelevamiento> findAllByRelevamiento(Long idRelevamiento) {
        Iterable<AppUbicacionRelevamiento> iterator = dao.findAllByIdRelevamiento_Id(idRelevamiento);

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void saveLatLong(MyObject object) {
        AppUbicacionRelevamiento ubicacion = this.get(object.getId());
        ubicacion.setLatitud(object.getLatitud());
        ubicacion.setLongitud(object.getLongitud());
        save(ubicacion);
    }
}

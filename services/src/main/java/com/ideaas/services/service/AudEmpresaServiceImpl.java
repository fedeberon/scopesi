package com.ideaas.services.service;

import com.ideaas.services.dao.AudEmpresaDao;
import com.ideaas.services.domain.AudEmpresa;
import com.ideaas.services.service.interfaces.AudEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudEmpresaServiceImpl implements AudEmpresaService {

    private AudEmpresaDao dao;

    @Autowired
    public AudEmpresaServiceImpl(AudEmpresaDao dao) {
        this.dao = dao;
    }

    @Override
    public AudEmpresa get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public AudEmpresa save(AudEmpresa audEmpresa) {
        return dao.save(audEmpresa);
    }

    @Override
    public List<AudEmpresa> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<AudEmpresa> audEmpresas = dao.findAll(paging);

        return audEmpresas.getContent();
    }

}

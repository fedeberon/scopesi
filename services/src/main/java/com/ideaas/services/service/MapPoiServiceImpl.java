package com.ideaas.services.service;

import com.ideaas.services.dao.MapPoiDao;
import com.ideaas.services.domain.MapPoi;
import com.ideaas.services.service.interfaces.MapPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapPoiServiceImpl implements MapPoiService {

    private MapPoiDao dao;

    @Autowired
    public MapPoiServiceImpl(MapPoiDao dao) {
        this.dao = dao;
    }

    @Override
    public MapPoi get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public MapPoi save(MapPoi mapPoi) {
        return dao.save(mapPoi);
    }

    @Override
    public List<MapPoi> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<MapPoi> mapPois = dao.findAll(paging);

        return mapPois.getContent();
    }
}

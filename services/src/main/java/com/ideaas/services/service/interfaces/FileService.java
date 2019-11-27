package com.ideaas.services.service.interfaces;

import com.ideaas.services.bean.Image;
import com.ideaas.services.domain.MapUbicacion;

import java.util.List;

public interface FileService {
    List<Image> readFiles(MapUbicacion mapUbicacion) ;
}

package com.ideaas.services.service;

import com.ideaas.services.bean.Image;
import com.ideaas.services.domain.MapUbicacion;
import com.ideaas.services.service.interfaces.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileServiceImpl implements FileService {

    @Value("${folderImage}")
    private String folderImage;

    @Value("${urlFileServer}")
    private String urlFileServer;


    @Override
    public List<Image> readFiles(MapUbicacion mapUbicacion)  {
        final List<Image> images = new ArrayList();
        String path = folderImage.concat(mapUbicacion.getAudEmpresa().getId().toString());
        try {
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    try {
                        String url = urlFileServer.concat(mapUbicacion.getAudEmpresa().getId().toString()).concat(File.separator).concat(file.getFileName().toString());
                        String nameImage = file.getFileName().toString().substring(0 , file.getFileName().toString().indexOf("."));

                        if(file.getFileName().toString().contains("(")) {
                            nameImage = file.getFileName().toString().substring(0, file.getFileName().toString().indexOf("("));
                        }

                        images.add(new Image( url , nameImage, false));
                    }
                    finally {
                        return FileVisitResult.CONTINUE;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Image> imageOfUbicacion = new ArrayList<>();
        images.forEach(image -> {
            if(image.getName().equals(mapUbicacion.getId().toString())){
                imageOfUbicacion.add(image);
            }
        });

        return imageOfUbicacion;

    }
}


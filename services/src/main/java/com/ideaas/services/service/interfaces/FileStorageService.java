package com.ideaas.services.service.interfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by federicoberon on 30/11/2019.
 */
public interface FileStorageService {
    String storeFile(MultipartFile file, String foldePath, String fileName);

    Resource loadFileAsResource(String fileName);
}

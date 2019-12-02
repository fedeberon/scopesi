package com.ideaas.services.service;


import com.ideaas.services.bean.FileStorageProperties;
import com.ideaas.services.exception.FileStorageException;
import com.ideaas.services.exception.MyFileNotFoundException;
import com.ideaas.services.service.interfaces.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/**
 * Created by federicoberon on 30/11/2019.
 */

@Service
public class FileStorageServiceImpl  implements FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public String storeFile(MultipartFile file, String folder, String fileName) {
        // Normalize file name
        //String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            String newName = this.resolveFileName(fileName);

            Path pathWithStandardizedName = newName(targetLocation, newName);
            Files.copy(file.getInputStream(), pathWithStandardizedName, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }


    Path newName(Path oldName, String newNameString) throws IOException {
        return Files.move(oldName, oldName.resolveSibling(newNameString));
    }


    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }


    private String resolveFileName(String fileNamme){
        int i = 0 ;
        Path path ;

        do {
            String newFileName = fileNamme.concat("(" + i +")");
            path = this.fileStorageLocation.resolve(newFileName);
            i++;
        }
        while(Files.exists(path));

        return path.getFileName().toString();
    }

}

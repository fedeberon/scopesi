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

import java.io.File;
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
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file, String folder, String fileName) {
        // Normalize file name
        /*String fileName = StringUtils.cleanPath(file.getOriginalFilename());*/

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            fileName = resolveFileName(file, folder, fileName);

            Path targetLocation = this.fileStorageLocation.resolve(folder.concat("//").concat(fileName));
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

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


    @Override
    public void delete(String folder, String fileName) {
        Path fileToDeletePath = this.fileStorageLocation.resolve(folder.concat("/").concat(fileName));
        try {
            Files.delete(fileToDeletePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getFileExtension(MultipartFile file) {
        String name = file.getOriginalFilename();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    private String resolveFileName(MultipartFile file, String folder, String fileNamme) throws IOException {
    int i = 1 ;
    String fileName;
    File newFile;
    String extention = getFileExtension(file);

    do {
        String newFileName = fileNamme;
        fileName = fileStorageLocation.toAbsolutePath().toString().concat(File.separator).concat(folder).concat(File.separator).concat(newFileName).concat("(" + i +")").concat(".").concat(extention);
        newFile = new File(fileName);
        i++;
    }
    while(newFile.getAbsoluteFile().exists());

    return newFile.getName();
}

}

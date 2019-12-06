package com.ideaas.web;

/**
 * Created by federicoberon on 24/10/2019.
 */

import com.ideaas.services.bean.FileStorageProperties;
import com.ideaas.services.bean.GoogleMapsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        FileStorageProperties.class, GoogleMapsProperties.class
})
@SpringBootApplication(scanBasePackages = {"com.ideaas"})
public class ScopesiWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScopesiWebApplication.class, args);
    }

}

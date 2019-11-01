package com.ideaas.web;

/**
 * Created by federicoberon on 24/10/2019.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ideaas"})
public class ScopesiWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScopesiWebApplication.class, args);
    }

}

package com.ideaas.services.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class MapUbicacionRequest {

    private String audEmpresa;

    private String mapElemento;

    private String mapProvincia;

    private String mapFormato;

    private String audLocalidad;

    private String mapMedio;

    private Boolean bajaLogica;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime fechaAlta;

}

package com.ideaas.services.request;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

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

    public String getAudEmpresa() {
        return audEmpresa;
    }

    public void setAudEmpresa(String audEmpresa) {
        this.audEmpresa = audEmpresa;
    }

    public String getMapElemento() {
        return mapElemento;
    }

    public void setMapElemento(String mapElemento) {
        this.mapElemento = mapElemento;
    }

    public String getMapProvincia() {
        return mapProvincia;
    }

    public void setMapProvincia(String mapProvincia) {
        this.mapProvincia = mapProvincia;
    }

    public String getMapFormato() {
        return mapFormato;
    }

    public void setMapFormato(String mapFormato) {
        this.mapFormato = mapFormato;
    }

    public String getAudLocalidad() {
        return audLocalidad;
    }

    public void setAudLocalidad(String audLocalidad) {
        this.audLocalidad = audLocalidad;
    }

    public String getMapMedio() {
        return mapMedio;
    }

    public void setMapMedio(String mapMedio) {
        this.mapMedio = mapMedio;
    }

    public Boolean getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(Boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}

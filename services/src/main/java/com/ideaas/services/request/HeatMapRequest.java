package com.ideaas.services.request;

import java.time.LocalDate;


public class HeatMapRequest {

    private Long[] edades;

    private String [] generos;

    private LocalDate fechaRecepcion;

    public Long[] getEdades() {
        return edades;
    }

    public void setEdades(Long[] edades) {
        this.edades = edades;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
}

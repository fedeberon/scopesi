package com.ideaas.services.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class MapUbicacionRequest {

    private String audEmpresa;

    private String mapElemento;

    private String mapProvincia;

    private String mapFormato;

    private String audLocalidad;

    private String mapMedio;

    private Integer page = 0;

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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }


    private static String EMPTY = "";

    private static String LEFT = "[";
    private static String RIGTH = "]";

    public String getEmpresasSelected(){
        if(Objects.isNull(audEmpresa)) return EMPTY;

        return buildFormatValuesSelected(audEmpresa);
    }

    public String getElementosSelected(){
        if(Objects.isNull(mapElemento)) return EMPTY;

        return buildFormatValuesSelected(mapElemento);
    }

    public String getFormatosSelected(){
        if(Objects.isNull(mapFormato)) return EMPTY;

        return buildFormatValuesSelected(mapFormato);
    }

    public String getMediosSelected(){
        if(Objects.isNull(mapMedio)) return EMPTY;

        return buildFormatValuesSelected(mapMedio);
    }

    public String getLocalidadesSelected(){
        if(Objects.isNull(audLocalidad)) return EMPTY;

        return buildFormatValuesSelected(audLocalidad);
    }

    public String getProvinciasSelected(){
        if(Objects.isNull(mapProvincia)) return EMPTY;

        return buildFormatValuesSelected(mapProvincia);
    }

    private String buildFormatValuesSelected(String value){
        String returnValue = EMPTY;

        String[] words = value.split(",");
        if(words.length < 1) return value;

        returnValue = returnValue.concat(LEFT);

        for(String s : words){
            returnValue = returnValue.concat("'".concat(s).concat("',"));
        }

        returnValue = returnValue.substring(0, returnValue.length() - 1);
        returnValue = returnValue.concat(RIGTH);

        return returnValue;
    }

}

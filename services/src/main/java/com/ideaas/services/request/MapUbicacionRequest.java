package com.ideaas.services.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MapUbicacionRequest {

    private Long id;

    private Long idEmpresa;

    private String audEmpresa;

    private Long idElemento;

    private String mapElemento;

    private Long idProvincia;

    private String mapProvincia;

    private Long idFormato;

    private String mapFormato;

    private Long idLocalidad;

    private String audLocalidad;

    private Long idMedio;

    private String mapMedio;

    private Boolean bajaLogica;

    private Date fechaAlta;

    private Boolean langLongEmpty;

    private List<Long> idsSelected;

    private BigDecimal latitud;

    private BigDecimal longitud;

    private Integer maxResults = 10;

    private Integer page = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLangLongEmpty() {
        return langLongEmpty;
    }

    public void setLangLongEmpty(Boolean langLongEmpty) {
        this.langLongEmpty = langLongEmpty;
    }

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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    public Long getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Long getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Long idFormato) {
        this.idFormato = idFormato;
    }

    public Long getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Long idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Long getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Long idMedio) {
        this.idMedio = idMedio;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public List<Long> getIdsSelected() {
        return idsSelected;
    }

    public void setIdsSelected(List<Long> idsSelected) {
        this.idsSelected = idsSelected;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
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

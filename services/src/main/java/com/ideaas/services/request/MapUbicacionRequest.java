package com.ideaas.services.request;

import com.ideaas.services.bean.RequestUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MapUbicacionRequest {

    private Long id;

    private Long idEmpresa;

    private String mapEmpresa;

    private Long idElemento;

    private String mapElemento;

    private Long idProvincia;

    private String mapProvincia;

    private Long idFormato;

    private String mapFormato;

    private Long idLocalidad;

    private String mapLocalidad;

    private Long idMedio;

    private String mapMedio;

    private String bajaLogica;

    private Date fechaAlta;

    private String latLngEmpty;

    private List<Long> idsSelected;

    private BigDecimal latitud;

    private BigDecimal longitud;

    private Long idAltura;

    private Long idVisibilidad;

    private Long metrosContactoRequest;

    private BigDecimal coeficienteRequest;

    private String maxResults = "10";

    private Integer page = 0;

    private String polygonLatLong;

    private Boolean bajaLogicaRequest;

    private String idsSearch;

    private String searchValue;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMapEmpresa() {
        return mapEmpresa;
    }

    public void setMapEmpresa(String mapEmpresa) {
        this.mapEmpresa = mapEmpresa;
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

    public String getMapLocalidad() {
        return mapLocalidad;
    }

    public void setMapLocalidad(String mapLocalidad) {
        this.mapLocalidad = mapLocalidad;
    }

    public String getMapMedio() {
        return mapMedio;
    }

    public void setMapMedio(String mapMedio) {
        this.mapMedio = mapMedio;
    }

    public String getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(String bajaLogica) {
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

    public String getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(String maxResults) {
        this.maxResults = maxResults;
    }

    public String getLatLngEmpty() {
        return latLngEmpty;
    }

    public void setLatLngEmpty(String latLngEmpty) {
        this.latLngEmpty = latLngEmpty;
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

    public Long getIdAltura() {
        return idAltura;
    }

    public void setIdAltura(Long idAltura) {
        this.idAltura = idAltura;
    }

    public Long getIdVisibilidad() {
        return idVisibilidad;
    }

    public void setIdVisibilidad(Long idVisibilidad) {
        this.idVisibilidad = idVisibilidad;
    }

    public Long getMetrosContactoRequest() {
        return metrosContactoRequest;
    }

    public void setMetrosContactoRequest(Long metrosContactoRequest) {
        this.metrosContactoRequest = metrosContactoRequest;
    }

    public BigDecimal getCoeficienteRequest() {
        return coeficienteRequest;
    }

    public void setCoeficienteRequest(BigDecimal coeficienteRequest) {
        this.coeficienteRequest = coeficienteRequest;
    }

    public String getPolygonLatLong() {
        return polygonLatLong;
    }

    public void setPolygonLatLong(String polygonLatLong) {
        this.polygonLatLong = polygonLatLong;
    }

    public Boolean getBajaLogicaRequest() {
        return bajaLogicaRequest;
    }

    public void setBajaLogicaRequest(Boolean bajaLogicaRequest) {
        this.bajaLogicaRequest = bajaLogicaRequest;
    }

    public String getIdsSearch() {
        return idsSearch;
    }

    public void setIdsSearch(String idsSearch) {
        this.idsSearch = idsSearch;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    private RequestUtil requestUtil = new RequestUtil();

    public String getEmpresasSelected(){
        if(Objects.isNull(mapEmpresa)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(mapEmpresa);
    }

    public String getElementosSelected(){
        if(Objects.isNull(mapElemento)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(mapElemento);
    }

    public String getFormatosSelected(){
        if(Objects.isNull(mapFormato)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(mapFormato);
    }

    public String getMediosSelected(){
        if(Objects.isNull(mapMedio)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(mapMedio);
    }

    public String getLocalidadesSelected(){
        if(Objects.isNull(mapLocalidad)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(mapLocalidad);
    }

    public String getProvinciasSelected(){
        if(Objects.isNull(mapProvincia)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(mapProvincia);
    }

    public String getEstadoSelected(){
        if(Objects.isNull(bajaLogica)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(bajaLogica);
    }
    public String getGeolocalizacionSelected(){
        if(Objects.isNull(latLngEmpty)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(latLngEmpty);
    }
    public String getIdsSearching(){
        if(Objects.isNull(idsSearch)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(idsSearch);
    }
    public String getValueSearching(){
        if(Objects.isNull(searchValue)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(searchValue);
    }
    public String getMaxResultsSelected(){
        if(Objects.isNull(maxResults)) return requestUtil.EMPTY;

        return requestUtil.buildFormatValuesSelected(maxResults);
    }
}

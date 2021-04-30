package com.ideaas.services.bean;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by federicoberon on 29/10/2019.
 */
@Component
public class MyObject {

    private Long id;
    private Boolean checked = false;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String name;
    private String description;
    private String address;
    private String provincia;
    private String localidad;
    private String polygonCoordinates;
    private Long idEmpresa;


    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public Boolean getChecked() {
        return checked;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getPolygonCoordinates() {
        return polygonCoordinates;
    }

    public void setPolygonCoordinates(String polygonCoordinates) {
        this.polygonCoordinates = polygonCoordinates;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}

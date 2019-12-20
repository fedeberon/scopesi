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
    private BigDecimal lat;
    private BigDecimal lon;
    private String name;
    private String description;
    private String address;

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

    public BigDecimal getLat() {
        return lat;
    }

    public BigDecimal getLon() {
        return lon;
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

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
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
}

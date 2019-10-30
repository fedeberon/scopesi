package com.ideaas.services.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by federicoberon on 29/10/2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyObject {

    private Long id;
    private Boolean checked = false;
    private BigDecimal lat;
    private BigDecimal lon;
    private String name;

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
}

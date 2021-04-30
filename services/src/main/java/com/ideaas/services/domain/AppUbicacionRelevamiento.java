package com.ideaas.services.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "app_ubicaciones_relevamientos")
public class AppUbicacionRelevamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUbicacion", unique= true, nullable= false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idRelevamiento")
    private AppRelevamiento idRelevamiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "geo_latitud")
    private BigDecimal latitud;

    @Column(name = "geo_longitud")
    private BigDecimal longitud;

    public AppUbicacionRelevamiento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppRelevamiento getIdRelevamiento() {
        return idRelevamiento;
    }

    public void setIdRelevamiento(AppRelevamiento idRelevamiento) {
        this.idRelevamiento = idRelevamiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }
}

package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_localidades")
@Data

public class MapLocalidad {

    @Id
    @Column (name = "idLocalidad")
    @SequenceGenerator(name = "MapLocalidadSeqGen", sequenceName = "SEQ_MAP_LOCALIDADES", allocationSize = 1)
    @GeneratedValue(generator = "MapLocalidadSeqGen")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn (name = "idProvincia")
    private AudProvincia audProvincia;

    @Column(name = "bajaLogica")
    private Boolean bajaLogica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public AudProvincia getAudProvincia() {
        return audProvincia;
    }

    public void setAudProvincia(AudProvincia audProvincia) {
        this.audProvincia = audProvincia;
    }

    public Boolean getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(Boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
    }

    public MapLocalidad() {
    }
}

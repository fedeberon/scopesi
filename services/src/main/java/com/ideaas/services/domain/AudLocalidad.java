package com.ideaas.services.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "aud_localidades")
@Data

public class AudLocalidad {

    @Id
    @Column(name = "idLocalidad")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private AudProvincia audProvincia;

    public AudLocalidad() {
    }
}

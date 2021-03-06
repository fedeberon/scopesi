package com.ideaas.services.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "map_anunciantes")
@Entity
@Data

public class MapAnunciante {

    @Id
    @Column(name = "idAnunciante")
    private Long id;

    @Column(name = "Descripcion")
    private String descripcion;

    public MapAnunciante() {
    }
}

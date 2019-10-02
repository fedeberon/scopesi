package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_provincias")
@Data

public class MapProvincia {
    @Id
    @Column(name = "idProvincia")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "evalua")
    private Long evalua;

    public MapProvincia() {
    }
}

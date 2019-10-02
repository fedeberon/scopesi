package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_medios")
@Data

public class MapMedio {

    @Id
    @Column(name = "idMedio")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public MapMedio() {
    }
}

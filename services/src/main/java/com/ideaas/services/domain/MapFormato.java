package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_formato")
@Data

public class MapFormato {

    @Id
    @Column(name = "idFormato")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "evalua")
    private Long evalua;

    public MapFormato() {
    }
}

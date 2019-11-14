package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_medios")
@Data

public class MapMedio {

    @Id
    @SequenceGenerator(name = "MapMedioSeqGen", sequenceName = "SEQ_MAP_MEDIOS", allocationSize = 1)
    @GeneratedValue(generator = "MapMedioSeqGen")
    @Column(name = "idMedio")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public MapMedio() {
    }
}

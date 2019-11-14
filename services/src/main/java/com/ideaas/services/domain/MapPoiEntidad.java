package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_pois_entidad")
@Data

public class MapPoiEntidad {

    @Id
    @Column(name = "idEntidad")
    @SequenceGenerator(name = "MapPoiEntidadSeqGen", sequenceName = "SEQ_MAP_POIS_ENTIDAD", allocationSize = 1)
    @GeneratedValue(generator = "MapPoiEntidadSeqGen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idSector")
    private MapPoiSector mapPoiSector;

    @Column(name = "descripcion")
    private String descripcion;

    public MapPoiEntidad() {
    }
}

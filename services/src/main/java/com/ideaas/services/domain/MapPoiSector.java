package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "map_pois_sector")
@Data

public class MapPoiSector {

    @Id
    @Column(name = "idSectorPoi")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public MapPoiSector() {
    }
}

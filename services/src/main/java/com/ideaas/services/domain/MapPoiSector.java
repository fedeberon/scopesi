package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_pois_sector")
@Data

public class MapPoiSector {

    @Id
    @Column(name = "idSectorPoi")
    @SequenceGenerator(name = "MapPoiSectorSeqGen", sequenceName = "SEQ_MAP_POIS_SECTOR", allocationSize = 1)
    @GeneratedValue(generator = "MapPoiSectorSeqGen")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "bajaLogica")
    private Boolean bajaLogica;

    public MapPoiSector() {
    }

    public Long getId() {
        return id;
    }

    public void setBajaLogica(Boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
    }
}

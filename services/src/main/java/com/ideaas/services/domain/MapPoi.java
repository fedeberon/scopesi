package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "map_pois")
@Data

public class MapPoi {

    @Id
    @Column(name = "idPoi")
    @SequenceGenerator(name = "MapPoiSeqGen", sequenceName = "SEQ_MAP_POIS", allocationSize = 1)
    @GeneratedValue(generator = "MapPoiSeqGen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEntidad")
    private MapPoiEntidad mapPoiEntidad;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private MapProvincia mapProvincia;

    @Column(name = "geo_latitud")
    private BigDecimal geoLatitud;

    @Column(name = "geo_longitud")
    private BigDecimal geoLongitud;

    @Column(name = "icono")
    private String icono;

    @Column(name = "bajaLogica")
    private Boolean bajaLogica;

    public MapPoi() {
    }
}

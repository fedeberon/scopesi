package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "map_elementos")
@Data

public class MapElemento {

    @Id
    @Column(name = "idElemento")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "panos")
    private Long panos;

    @ManyToOne
    @JoinColumn(name = "idMedio")
    private MapMedio mapMedio;

    @ManyToOne
    @JoinColumn(name = "idFormato")
    private MapFormato mapFormato;

    @Column(name = "acumulaDatos")
    private Long acumulaDatos;

    @Column(name = "evalua")
    private Long evalua;

    @Column(name = "metrosContacto")
    private Long metrosContacto;

    @Column(name = "coeficiente")
    private BigDecimal coeficiente;

    public MapElemento() {
    }
}

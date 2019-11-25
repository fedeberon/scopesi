package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_formato")
@Data

public class MapFormato {

    @Id
    @SequenceGenerator(name = "MapFormatoSeqGen", sequenceName = "SEQ_MAP_FORMATO", allocationSize = 1)
    @GeneratedValue(generator = "MapFormatoSeqGen")
    @Column(name = "idFormato")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "evalua")
    private Long evalua;

    public MapFormato() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getEvalua() {
        return evalua;
    }

    public void setEvalua(Long evalua) {
        this.evalua = evalua;
    }
}

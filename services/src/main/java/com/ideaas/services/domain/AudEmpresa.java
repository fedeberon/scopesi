package com.ideaas.services.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "aud_empresas")
@Data

public class AudEmpresa {

    @Id
    @Column(name = "idEmpresa")
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "mySeqGen")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public AudEmpresa() {
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
}

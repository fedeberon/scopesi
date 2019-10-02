package com.ideaas.services.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aud_empresas")
@Data

public class AudEmpresa {

    @Id
    @Column(name = "idEmpresa")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public AudEmpresa() {
    }
}

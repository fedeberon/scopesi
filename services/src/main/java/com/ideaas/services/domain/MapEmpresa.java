package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_empresas")
@Data

public class MapEmpresa {

    @Id
    @Column(name = "idEmpresa")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "mail")
    private String mail;

    @Column(name = "logo")
    private String logo;

    @Column(name = "orden")
    private Long orden;

    @Column(name = "html")
    private String html;

    @Column(name = "gpmas")
    private Boolean GPMas;

    public MapEmpresa() {
    }
}

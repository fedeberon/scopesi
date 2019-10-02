package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tipo_usuarios")
@Data

public class TipoUsuario {

    @Id
    @Column(name = "idTipoUsuario")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    public TipoUsuario() {
    }
}

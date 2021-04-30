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

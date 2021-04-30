package com.ideaas.services.domain;

import javax.persistence.*;

@Entity
@Table(name = "app_encuestas")
public class AppEncuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEncuesta", unique= true, nullable= false)
    private Long id;

    @Column(name = "nombreEncuesta")
    private String nombreEncuesta;

    @Column(name = "linkPublicacion")
    private String linkPublicacion;

    @Column(name = "linkEdicion")
    private String linkEdicion;

    public AppEncuesta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEncuesta() {
        return nombreEncuesta;
    }

    public void setNombreEncuesta(String nombreEncuesta) {
        this.nombreEncuesta = nombreEncuesta;
    }

    public String getLinkPublicacion() {
        return linkPublicacion;
    }

    public void setLinkPublicacion(String linkPublicacion) {
        this.linkPublicacion = linkPublicacion;
    }

    public String getLinkEdicion() {
        return linkEdicion;
    }

    public void setLinkEdicion(String linkEdicion) {
        this.linkEdicion = linkEdicion;
    }
}

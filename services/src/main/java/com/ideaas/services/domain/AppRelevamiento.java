package com.ideaas.services.domain;

import javax.persistence.*;

@Entity
@Table(name = "app_relevamientos")
public class AppRelevamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRelevamiento", unique= true, nullable= false)
    private Long id;

    @Column(name = "nombreRelevamiento")
    private String nombreRelevamiento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idEncuesta")
    private AppEncuesta encuesta;

    public AppRelevamiento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRelevamiento() {
        return nombreRelevamiento;
    }

    public void setNombreRelevamiento(String nombreRelevamiento) {
        this.nombreRelevamiento = nombreRelevamiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AppEncuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(AppEncuesta encuesta) {
        this.encuesta = encuesta;
    }
}

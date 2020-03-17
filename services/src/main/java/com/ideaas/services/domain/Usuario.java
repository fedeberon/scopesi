package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data

public class Usuario {

    @Id
    @Column(name = "idUsuario")
    private Long id;

    @Column(name = "usuario")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    @Column(name = "eMail")
    private String eMail;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;

    //Cliente depreco esta columna
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAnunciante")
    private MapAnunciante mapAnunciante;

    //Cliente depreco esta columna
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "cargo")
    private String cargo;

    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idContratoInv")
    private ContratoInversion contratoInversion;

    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idContratoAud")
    private ContratoAuditoria contratoAuditoria;

    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idContratoMap")
    private ContratoMapping contratoMapping;

    public Usuario() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public MapAnunciante getMapAnunciante() {
        return mapAnunciante;
    }

    public void setMapAnunciante(MapAnunciante mapAnunciante) {
        this.mapAnunciante = mapAnunciante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ContratoInversion getContrato() {
        return contratoInversion;
    }

    public void setContrato(ContratoInversion contratoInversion) {
        this.contratoInversion = contratoInversion;
    }

    public ContratoAuditoria getContratoAuditoria() {
        return contratoAuditoria;
    }

    public void setContratoAuditoria(ContratoAuditoria contratoAuditoria) {
        this.contratoAuditoria = contratoAuditoria;
    }

    public ContratoMapping getContratoMapping() {
        return contratoMapping;
    }

    public void setContratoMapping(ContratoMapping contratoMapping) {
        this.contratoMapping = contratoMapping;
    }
}
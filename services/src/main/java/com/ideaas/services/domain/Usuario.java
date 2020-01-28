package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

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

    //problemas con el id=0/DB
    @ManyToOne
    @JoinColumn(name = "idAnunciante")
    private Anunciante mapAnunciante;

    //problemas con el id=0/DB
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "cargo")
    private String cargo;

    //problemas con el id=0/DB

    @ManyToOne
    @JoinColumn(name = "idContratoInv")
    private Contrato contrato;

    //problemas con el id=0/DB

    @ManyToOne
    @JoinColumn(name = "idContratoAud")
    private Contrato contratoA;

    //problemas con el id=0/DB

    @ManyToOne
    @JoinColumn(name = "idContratoMap")
    private Contrato contratoM;

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

    public Anunciante getMapAnunciante() {
        return mapAnunciante;
    }

    public void setMapAnunciante(Anunciante mapAnunciante) {
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Contrato getContratoA() {
        return contratoA;
    }

    public void setContratoA(Contrato contratoA) {
        this.contratoA = contratoA;
    }

    public Contrato getContratoM() {
        return contratoM;
    }

    public void setContratoM(Contrato contratoM) {
        this.contratoM = contratoM;
    }
}
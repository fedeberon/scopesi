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
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAnunciante")
    private Anunciante mapAnunciante;

    //problemas con el id=0/DB
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "cargo")
    private String cargo;

    //problemas con el id=0/DB
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idContratoInv")
    private ContratoInversion contratoInversion;

    //problemas con el id=0/DB
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idContratoAud")
    private ContratoAuditoria contratoAuditoria;

    //problemas con el id=0/DB
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idContratoMap")
    private ContratoMapping contratoMapping;

    public Usuario() { }
}
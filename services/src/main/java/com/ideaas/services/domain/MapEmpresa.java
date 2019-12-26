package com.ideaas.services.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "map_empresas")
@Data

public class MapEmpresa {

    @Id
    @Column(name = "idEmpresa")
    @SequenceGenerator(name = "MapEmpresaSeqGen", sequenceName = "SEQ_MAP_EMPRESA", allocationSize = 1)
    @GeneratedValue(generator = "MapEmpresaSeqGen")
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

    @Column(name = "bajaLogica")
    private Boolean bajaLogica;

    public Boolean getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(Boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Boolean getGPMas() {
        return GPMas;
    }

    public void setGPMas(Boolean GPMas) {
        this.GPMas = GPMas;
    }

    public MapEmpresa() {
    }
}

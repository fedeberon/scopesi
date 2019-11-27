package com.ideaas.services.domain;


import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "map_ubicaciones")
@Data
public class MapUbicacion implements Serializable {

    @Id
    @Column(name = "idUbicacion")
    @SequenceGenerator(name = "MapUbicacionSeqGen", sequenceName = "SEQ_MAP_UBICACION", allocationSize = 1)
    @GeneratedValue(generator = "MapUbicacionSeqGen")
    private Long id;

    //deberia apuntar a MapEmpresa
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private AudEmpresa audEmpresa;

    @ManyToOne
    @JoinColumn(name = "idElemento")
    private MapElemento mapElemento;

    @ManyToOne
    @JoinColumn(name = "idFormato")
    private MapFormato mapFormato;

    @ManyToOne
    @JoinColumn(name = "idMedio")
    private MapMedio mapMedio;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nro_agip")
    private String nroAgip;

    @Column(name = "Referencia")
    private String referencia;

    @Column(name = "Nro_Anuncio")
    private Long nroAnuncio;

    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private MapProvincia mapProvincia;

    //deberia apuntar a Maplocalidad
    @ManyToOne
    @JoinColumn(name = "idLocalidad")
    private AudLocalidad audLocalidad;

    @Column(name = "Anunciante")
    private String anunciante;

    @Column(name = "cantidad")
    private Long cantidad;

    @Column(name = "transito")
    private String transito;

    @Column(name = "iluminacion")
    private String iluminacion;

    @Column(name = "Medidas")
    private String medidas;

    @Column(name = "M2")
    private String m2;

    @Column(name = "Direccion_Normalizada")
    private String direccionNormalizada;

    @Column(name = "geo_latitud")
    private BigDecimal latitud;

    @Column(name = "geo_longitud")
    private BigDecimal longitud;

    @Column(name = "metroscontacto")
    private Long metrosContacto;

    @Column(name = "coeficiente")
    private BigDecimal coeficiente;

    @Column(name = "zona")
    private Long zona;

    @Column(name = "Saturacion")
    private String saturacion;

    @Column(name = "visibilidad")
    private Long visibilidad;

    @Column(name = "circulacion_peatonal")
    private String circulacionPeatonal;

    @Column(name = "Circulacion_Vehicular")
    private String circulacionVehicular;

    @Column(name = "id_referencia")
    private String idReferencia;

    //Problemas con id=0
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMapBuses")
    private MapBus mapBuses;

    @Column(name = "bajaLogica")
    private Boolean bajaLogica;

    @Column(name = "fechatransf")
    private LocalDateTime fechaTransf;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @ManyToOne
    @JoinColumn(name = "id_altura")
    private MapUbicacionAltura mapUbicacionAltura;

    @ManyToOne
    @JoinColumn(name = "id_visibilidad")
    private MapUbicacionVisibilidad mapUbicacionVisibilidad;

    public MapUbicacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AudEmpresa getAudEmpresa() {
        return audEmpresa;
    }

    public void setAudEmpresa(AudEmpresa audEmpresa) {
        this.audEmpresa = audEmpresa;
    }

    public MapElemento getMapElemento() {
        return mapElemento;
    }

    public void setMapElemento(MapElemento mapElemento) {
        this.mapElemento = mapElemento;
    }

    public MapFormato getMapFormato() {
        return mapFormato;
    }

    public void setMapFormato(MapFormato mapFormato) {
        this.mapFormato = mapFormato;
    }

    public MapMedio getMapMedio() {
        return mapMedio;
    }

    public void setMapMedio(MapMedio mapMedio) {
        this.mapMedio = mapMedio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNroAgip() {
        return nroAgip;
    }

    public void setNroAgip(String nroAgip) {
        this.nroAgip = nroAgip;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Long getNroAnuncio() {
        return nroAnuncio;
    }

    public void setNroAnuncio(Long nroAnuncio) {
        this.nroAnuncio = nroAnuncio;
    }

    public MapProvincia getMapProvincia() {
        return mapProvincia;
    }

    public void setMapProvincia(MapProvincia mapProvincia) {
        this.mapProvincia = mapProvincia;
    }

    public AudLocalidad getAudLocalidad() {
        return audLocalidad;
    }

    public void setAudLocalidad(AudLocalidad audLocalidad) {
        this.audLocalidad = audLocalidad;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getTransito() {
        return transito;
    }

    public void setTransito(String transito) {
        this.transito = transito;
    }

    public String getIluminacion() {
        return iluminacion;
    }

    public void setIluminacion(String iluminacion) {
        this.iluminacion = iluminacion;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getDireccionNormalizada() {
        return direccionNormalizada;
    }

    public void setDireccionNormalizada(String direccionNormalizada) {
        this.direccionNormalizada = direccionNormalizada;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public Long getMetrosContacto() {
        return metrosContacto;
    }

    public void setMetrosContacto(Long metrosContacto) {
        this.metrosContacto = metrosContacto;
    }

    public BigDecimal getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(BigDecimal coeficiente) {
        this.coeficiente = coeficiente;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long zona) {
        this.zona = zona;
    }

    public String getSaturacion() {
        return saturacion;
    }

    public void setSaturacion(String saturacion) {
        this.saturacion = saturacion;
    }

    public Long getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(Long visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getCirculacionPeatonal() {
        return circulacionPeatonal;
    }

    public void setCirculacionPeatonal(String circulacionPeatonal) {
        this.circulacionPeatonal = circulacionPeatonal;
    }

    public String getCirculacionVehicular() {
        return circulacionVehicular;
    }

    public void setCirculacionVehicular(String circulacionVehicular) {
        this.circulacionVehicular = circulacionVehicular;
    }

    public String getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(String idReferencia) {
        this.idReferencia = idReferencia;
    }

    public MapBus getMapBuses() {
        return mapBuses;
    }

    public void setMapBuses(MapBus mapBuses) {
        this.mapBuses = mapBuses;
    }

    public Boolean getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(Boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
    }

    public LocalDateTime getFechaTransf() {
        return fechaTransf;
    }

    public void setFechaTransf(LocalDateTime fechaTransf) {
        this.fechaTransf = fechaTransf;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public MapUbicacionAltura getMapUbicacionAltura() {
        return mapUbicacionAltura;
    }

    public void setMapUbicacionAltura(MapUbicacionAltura mapUbicacionAltura) {
        this.mapUbicacionAltura = mapUbicacionAltura;
    }

    public MapUbicacionVisibilidad getMapUbicacionVisibilidad() {
        return mapUbicacionVisibilidad;
    }

    public void setMapUbicacionVisibilidad(MapUbicacionVisibilidad mapUbicacionVisibilidad) {
        this.mapUbicacionVisibilidad = mapUbicacionVisibilidad;
    }
}

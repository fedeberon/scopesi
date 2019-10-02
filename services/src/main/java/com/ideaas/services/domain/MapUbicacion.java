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
}

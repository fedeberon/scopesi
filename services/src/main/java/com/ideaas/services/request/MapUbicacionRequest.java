package com.ideaas.services.request;

import com.ideaas.services.domain.AudEmpresa;
import lombok.Data;

@Data
public class MapUbicacionRequest {

    private String audEmpresa;

    private String mapElemento;

    private String mapProvincia;

    private String mapFormato;

    private String audLocalidad;

    private String mapMedio;

}

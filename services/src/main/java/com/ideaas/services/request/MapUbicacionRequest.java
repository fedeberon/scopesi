package com.ideaas.services.request;

import com.ideaas.services.domain.AudEmpresa;
import lombok.Data;

@Data
public class MapUbicacionRequest {

    private Long id;

    private AudEmpresa audEmpresa;

}

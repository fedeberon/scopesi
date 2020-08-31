package com.ideaas.services.dao;

import com.ideaas.services.domain.Contrato;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContratoDao extends PagingAndSortingRepository<Contrato, Long> {

    List<Contrato> findByEstadoNotAndTipoContratoOrderByDescripcionAsc(String estado , String tipoContrato);
}

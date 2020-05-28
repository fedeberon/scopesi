package com.ideaas.services.dao;

import com.ideaas.services.domain.Contrato;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContratoDao extends PagingAndSortingRepository<Contrato, Long> {
}

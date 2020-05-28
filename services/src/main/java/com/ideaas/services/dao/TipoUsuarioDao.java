package com.ideaas.services.dao;

import com.ideaas.services.domain.TipoUsuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TipoUsuarioDao extends PagingAndSortingRepository<TipoUsuario, Long> {
}

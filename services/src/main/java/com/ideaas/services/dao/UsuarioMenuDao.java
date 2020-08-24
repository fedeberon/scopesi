package com.ideaas.services.dao;

import com.ideaas.services.domain.UsuarioMenu;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioMenuDao extends PagingAndSortingRepository<UsuarioMenu, Long> {
}

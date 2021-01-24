package com.ideaas.services.dao;

import com.ideaas.services.domain.UsuarioMenu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioMenuDao extends PagingAndSortingRepository<UsuarioMenu, Long> {

    List<UsuarioMenu> findByUsuarioMenuId_IdUsuario(Long idUsuario);
}

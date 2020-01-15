package com.ideaas.services.dao;

import com.ideaas.services.domain.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    Usuario findByEstadoAndUsernameIs(String estado ,String username);

}

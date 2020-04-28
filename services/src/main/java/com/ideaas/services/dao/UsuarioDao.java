package com.ideaas.services.dao;

import com.ideaas.services.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    Usuario findByEstadoAndUsernameIs(String estado ,String username);

    @Query("SELECT u FROM Usuario u WHERE u.eMail = :email")
    Usuario getByEmail(@Param("email") String email);
}

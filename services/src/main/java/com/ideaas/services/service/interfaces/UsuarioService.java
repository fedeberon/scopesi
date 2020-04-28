package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UsuarioService extends UserDetailsService {

    Usuario get(Long id);

    Usuario save(Usuario usuario);

    Usuario getByEmail(String email);

    List<Usuario> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<Usuario> findAll();
}

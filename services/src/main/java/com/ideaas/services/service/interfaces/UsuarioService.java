package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.TipoUsuario;
import com.ideaas.services.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UsuarioService extends UserDetailsService {

    Usuario get(Long id);

    Usuario save(Usuario usuario);

    Usuario getByEmail(String email);

    Usuario getByUsername (String username);

    List<Usuario> findAll(Integer pageSize, Integer pageNo, String sortBy);

    List<Usuario> findAll();

    List<Usuario> findByEstadoNot(String estado);

    List<Usuario> findAllByTipoUsuario(Long idTipoUsuario);
}

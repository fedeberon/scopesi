package com.ideaas.services.service;

import com.ideaas.services.dao.UsuarioDao;
import com.ideaas.services.domain.Usuario;
import com.ideaas.services.service.interfaces.AllowedStatusService;
import com.ideaas.services.service.interfaces.AllowedTipoUsuarioService;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDao dao;

    private AllowedStatusService allowedStatusService;

    private AllowedTipoUsuarioService allowedTipoUsuarioService;

    @Autowired
    public UsuarioServiceImpl(UsuarioDao dao, AllowedStatusService allowedStatusService , AllowedTipoUsuarioService allowedTipoUsuarioService) {
        this.dao = dao;
        this.allowedStatusService = allowedStatusService;
        this.allowedTipoUsuarioService = allowedTipoUsuarioService;
    }

    @Override
    public Usuario get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return dao.save(usuario);
    }

    @Override
    public Usuario getByEmail(String email) {
        return dao.getByEmail(email);
    }

    @Override
    public Usuario getByUsername(String username) {
        return dao.getByUsername(username);
    }

    @Override
    public List<Usuario> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Usuario> usuarios = dao.findAll(paging);

        return usuarios.getContent();
    }

    @Override
    public List<Usuario> findAll() {
        Iterable<Usuario> iterator = dao.findAll();

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Usuario> findByEstadoNot(String estado) {
        Iterable<Usuario> iterator = dao.findByEstadoNot(estado);

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Usuario> findAllByTipoUsuario(Long idTipoUsuario) {
        Iterable<Usuario> iterator = dao.findAllByTipoUsuario_Id(idTipoUsuario);

        return  StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = dao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        boolean enabled = isEnabled(user);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled, true, true, true, new ArrayList<>());
    }

    private boolean isEnabled(Usuario user){
        return allowedStatusService.existsByDescripcion(user.getEstado()) && allowedTipoUsuarioService.existsByTipoUsuario_Id(user.getTipoUsuario().getId());
    }
}

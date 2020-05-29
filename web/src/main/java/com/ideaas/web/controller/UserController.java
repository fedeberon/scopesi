package com.ideaas.web.controller;

import com.ideaas.services.bean.AESPasswordEncoder;
import com.ideaas.services.domain.Contrato;
import com.ideaas.services.domain.TipoUsuario;
import com.ideaas.services.domain.Usuario;
import com.ideaas.services.service.interfaces.ContratoService;
import com.ideaas.services.service.interfaces.EmailService;
import com.ideaas.services.service.interfaces.TipoUsuarioService;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;

/**
 * Created by federicoberon on 08/10/2019.
 */
@Controller
@RequestMapping("usuario")
public class UserController {

    private UsuarioService usuarioService;
    private TipoUsuarioService tipoUsuarioService;
    private ContratoService contratoService;
    private AESPasswordEncoder encoder;


    @Autowired
    public UserController(UsuarioService usuarioService , TipoUsuarioService tipoUsuarioService, ContratoService contratoService) {
        this.usuarioService = usuarioService;
        this.tipoUsuarioService = tipoUsuarioService;
        this.contratoService = contratoService;
        this.encoder = new AESPasswordEncoder();
    }

    @RequestMapping("list")
    public String findAll(Model model){
        List<Usuario> users = usuarioService.findAll();
        users.forEach(user->{
            String passwordDecrypt = null;
            try {
                passwordDecrypt = encoder.decrypt(user.getPassword());
            } catch (InvalidCipherTextException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            user.setPassword(passwordDecrypt);
        });
        model.addAttribute("usuarios", users );

        return "usuario/list";
    }

    @RequestMapping("/autorizacion")
    public String hello(HttpServletRequest request, @CookieValue("Authorization") String authorization, @CookieValue("Token") String token) {
            String username = authorization.substring(6);
            UserDetails userDetails = usuarioService.loadUserByUsername(username);

            if (Objects.nonNull(userDetails) && userDetails.getPassword().equals(token)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    return "panel";
            }

            else return "login";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) throws UnsupportedEncodingException, InvalidCipherTextException {
        Usuario usuario = usuarioService.get(id);

        String passwordDecrypt = null;

        passwordDecrypt = encoder.decrypt(usuario.getPassword());

        usuario.setPassword(passwordDecrypt);

        model.addAttribute("usuario", usuario);

        return "usuario/show";
    }

    FieldError usernameExist = new FieldError(
"usuario" , "username" , "El usuario ya existe"
    );
    FieldError emptyUsername = new FieldError(
"usuario" , "username" , "Debes completar este campo"
    );
    FieldError emptyPassword = new FieldError(
"usuario" , "password" , "Debes completar este campo"
    );

    @RequestMapping(value = "save" , method = RequestMethod.POST)
    public String save(@ModelAttribute Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws InvalidCipherTextException {

        boolean error = false;

        if( usuarioService.getByUsername(usuario.getUsername()) != null){
            bindingResult.addError(usernameExist);
            error = true;
        }
        if(usuario.getUsername().isEmpty()){
            bindingResult.addError(emptyUsername);
            error = true;
        }
        if(usuario.getPassword().isEmpty()){
            bindingResult.addError(emptyPassword);
            error = true;
        }

        if(error) {
            return "usuario/create";
        } else {
            usuario.setPassword(encoder.encrypt(usuario.getPassword()));
            usuarioService.save(usuario);
            redirectAttributes.addAttribute("id", usuario.getId());
            error = false;

            return "redirect:/usuario/{id}";
        }
    }

    @RequestMapping(value = "update" , method = RequestMethod.POST)
    public String update(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) throws InvalidCipherTextException {

        usuario.setPassword(encoder.encrypt(usuario.getPassword()));
        usuarioService.save(usuario);
        redirectAttributes.addAttribute("id", usuario.getId());

        return "redirect:/usuario/{id}";
    }

    @GetMapping("create")
    public String create() {
        return "usuario/create";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Usuario usuario = usuarioService.get(id);
        String passwordDecrypt = null;
        try {
            passwordDecrypt = encoder.decrypt(usuario.getPassword());
        } catch (InvalidCipherTextException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        usuario.setPassword(passwordDecrypt);

        model.addAttribute("usuario", usuario);
        return "usuario/update";
    }

    @RequestMapping("dropState")
    public String dropState(@RequestParam Long id, Model model, RedirectAttributes redirectAttributes){
        Usuario usuario = usuarioService.get(id);
        usuario.setEstado("B");
        usuarioService.save(usuario);
        redirectAttributes.addAttribute("id", usuario.getId());

        return "redirect:/usuario/{id}";
    }

    @RequestMapping("upState")
    public String upState(@RequestParam Long id, Model model, RedirectAttributes redirectAttributes){
        Usuario usuario = usuarioService.get(id);
        usuario.setEstado("A");
        usuarioService.save(usuario);
        redirectAttributes.addAttribute("id", usuario.getId());

        return "redirect:/usuario/{id}";
    }

    @ModelAttribute("usuario")
    public Usuario get(){
        return new Usuario();
    }

    @ModelAttribute("tiposUsuarios")
    public List<TipoUsuario> tiposUsuario(){
        return tipoUsuarioService.findAll();
    }

    @ModelAttribute("contratos")
    public List<Contrato> contratos(){
        return contratoService.findAll();
    }

}

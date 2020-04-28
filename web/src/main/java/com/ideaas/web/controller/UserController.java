package com.ideaas.web.controller;

import com.ideaas.services.bean.AESPasswordEncoder;
import com.ideaas.services.domain.Usuario;
import com.ideaas.services.service.interfaces.EmailService;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * Created by federicoberon on 08/10/2019.
 */
@Controller
@RequestMapping("user")
public class UserController {

    private UsuarioService usuarioService;

    @Autowired
    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("list")
    public String findAll(Model model){
        List<Usuario> users = usuarioService.findAll();
        model.addAttribute("users", users );

        return "user/list";
    }

    @RequestMapping("/auth")
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

//    @RequestMapping("/sendMailToUser")
//    public ResponseEntity<?> sendMailToUser(@RequestParam Long id){
//        Usuario usuario = usuarioService.get(id);
//        Email email = new Email();
//        email.setTo(new String[]{usuario.geteMail()});
//        email.setSubject("Recuperacion de cuenta");
//        try {
//            String password = encoder.decrypt(usuario.getPassword());
//            email.setText("Your username is: '"+ usuario.getUsername() + "'" + "\r\n" +"and your password is: '".concat(password) + "'");
//            emailService.send(email);
//        } catch (InvalidCipherTextException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
}

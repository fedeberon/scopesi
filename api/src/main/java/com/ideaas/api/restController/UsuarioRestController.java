package com.ideaas.api.restController;

import com.ideaas.services.bean.AESPasswordEncoder;
import com.ideaas.services.bean.Email;
import com.ideaas.services.domain.Usuario;
import com.ideaas.services.service.interfaces.EmailService;
import com.ideaas.services.service.interfaces.UsuarioService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {

    private UsuarioService usuarioService;

    private AESPasswordEncoder aesPasswordEncoder;

    private EmailService emailService;

    @Autowired
    public UsuarioRestController(UsuarioService usuarioService, AESPasswordEncoder aesPasswordEncoder, EmailService emailService) {
        this.usuarioService = usuarioService;
        this.aesPasswordEncoder = aesPasswordEncoder;
        this.emailService = emailService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Usuario get(@PathVariable Long id){
        return usuarioService.get(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}/{pageNo}/{sortBy}")
    public List<Usuario> findAll(@PathVariable Integer pageSize, @PathVariable Integer pageNo, @PathVariable String sortBy){
        return usuarioService.findAll(pageSize, pageNo, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}/{pageNo}")
    public List<Usuario> findAll(@PathVariable Integer pageSize, @PathVariable Integer pageNo){
        return usuarioService.findAll(pageSize, pageNo, "id");
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list/{pageSize}")
    public List<Usuario> findAll(@PathVariable Integer pageSize){
        return usuarioService.findAll(pageSize, 0, "id");
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario newMapUsuario){
        Usuario usuario = usuarioService.save(newMapUsuario);

        return new ResponseEntity(usuario, HttpStatus.CREATED);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Send mail Successfully"),
            @ApiResponse(code = 502, message = "Failed when try to send a email"),
    })
    @GetMapping("send")
    public ResponseEntity<?> sendMailToUser(@RequestParam Long id){
        Usuario usuario = usuarioService.get(id);
        Email email = new Email();
        email.setTo(new String[]{usuario.geteMail()});
        try {
            String password = aesPasswordEncoder.decrypt(usuario.getPassword());
            email.setText("Su password es: ".concat(password));
            emailService.send(email);

        } catch (InvalidCipherTextException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

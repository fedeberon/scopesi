package com.ideaas.api.restController;

import com.ideaas.services.bean.Email;
import com.ideaas.services.service.interfaces.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("email")
@Api(value = "Send Mail", description = "Operations pertaining to import league.")
public class EmailRestController {

    @Autowired
    private EmailService emailService;

    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Send mail Successfully"),
            @ApiResponse(code = 502, message = "Failed when try to send a email"),
    })
    @GetMapping("send")
    public ResponseEntity<?> sendMail(@RequestBody Email email){
        try {
            emailService.send(email);
        } catch (MessagingException e) {
            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}

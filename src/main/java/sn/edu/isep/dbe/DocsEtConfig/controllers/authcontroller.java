package sn.edu.isep.dbe.DocsEtConfig.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.LoginRequest;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.LoginResponse;
import sn.edu.isep.dbe.DocsEtConfig.services.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class authcontroller {

    private final UserService userService;

    public authcontroller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {

        System.out.println("########################login");
        System.out.println("le login est"+loginRequest.getLogin());
        System.out.println("le mot de passe est"+loginRequest.getPassword());


        LoginResponse loginResponse = userService.login(loginRequest.getLogin(), loginRequest.getPassword());

        System.out.println("loginResponse="+loginResponse);
        if (loginResponse != null) {
            return ResponseEntity.status(450).body("Le login ou le mot de passe est incorrecte");
        }
        else{
            return ResponseEntity.ok(loginRequest);
        }
    }
}

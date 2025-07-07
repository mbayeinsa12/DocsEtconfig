package sn.edu.isep.dbe.DocsEtConfig.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.LoginRequest;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.LoginResponse;
import sn.edu.isep.dbe.DocsEtConfig.services.UserService;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        // Logs de débogage
        System.out.println("########## Login ! ########");
        System.out.println("Le login est : " + loginRequest.getUsername());
        System.out.println("Le mot de passe est : " + loginRequest.getPassword());

        LoginResponse loginResponse = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

        System.out.println("loginReponse = " + loginResponse);

        if (loginResponse == null) {
            return ResponseEntity.status(450).body("Le login ou le mot de passe est incorrect !");
        } else {
            return ResponseEntity.ok(loginResponse);
        }
    }
}

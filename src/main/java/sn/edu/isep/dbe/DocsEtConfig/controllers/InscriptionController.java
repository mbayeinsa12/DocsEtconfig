package sn.edu.isep.dbe.DocsEtConfig.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;
import sn.edu.isep.dbe.DocsEtConfig.entities.Droit;
import sn.edu.isep.dbe.DocsEtConfig.entities.Role;
import sn.edu.isep.dbe.DocsEtConfig.entities.User;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.InscriptionRequest;
import sn.edu.isep.dbe.DocsEtConfig.services.DroitService;
import sn.edu.isep.dbe.DocsEtConfig.services.RoleService;
import sn.edu.isep.dbe.DocsEtConfig.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscription")
public class InscriptionController {

    private final RoleService roleService;
    private final UserService userService;
    private final DroitService droitService;

    public InscriptionController(RoleService roleService, UserService userService, DroitService droitService) {
        this.roleService = roleService;
        this.userService = userService;
        this.droitService = droitService;
    }


    @PostMapping
    public ResponseEntity<?> inscrire(@RequestBody InscriptionRequest request) {
        List<Role> roles = request.getRoles().stream()
                .map(roleName -> roleService.findByName(roleName).get())
                .toList();
        List<Droit> droits=request.getDroits().stream()
                .map(droitName -> droitService.findDroitByNom(droitName).get())
                .toList();
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .adresse(request.getAdresse())
                .roles(roles)
                .droits(droits)
                .build();

        userService.save(user);
        return ResponseEntity.status(201)
                .build();
    }
    }



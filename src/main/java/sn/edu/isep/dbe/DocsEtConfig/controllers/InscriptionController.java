package sn.edu.isep.dbe.DocsEtConfig.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;
import sn.edu.isep.dbe.DocsEtConfig.entities.Role;
import sn.edu.isep.dbe.DocsEtConfig.entities.User;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.InscriptionRequest;
import sn.edu.isep.dbe.DocsEtConfig.services.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscription")
public class InscriptionController {

    private final RoleService roleService;

    public InscriptionController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public EntityResponse<?>inscrire(@RequestBody InscriptionRequest request) {
        List<Role> roles = request.getRoles().stream()
                .map(roleName -> roleService.findByNom(roleName).get())
                .toList();
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .adresse(request.getAdresse())
                .build();
    }
    }
}

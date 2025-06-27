package sn.edu.isep.dbe.DocsEtConfig.services;

import org.springframework.stereotype.Service;
import sn.edu.isep.dbe.DocsEtConfig.entities.Role;
import sn.edu.isep.dbe.DocsEtConfig.entities.User;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.LoginResponse;
import sn.edu.isep.dbe.DocsEtConfig.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(String email) {

        return userRepository.findByEmail(email);
    }
    public LoginResponse login(String email, String password) {
        Optional<User> userData = userRepository.findByEmail(email);
        if (userData.isPresent()) {
            User user = userData.get();

            //comparaison du mot de passe saisi
            if (user.getPassword().equals(password)) {

                //Creation d'une liste pour stocker les droit
                List<String> roles = new ArrayList<>();

                List<String> droits = new ArrayList<>();


                //on parcour des roles de l'utilisateur
                for (Role role : user.getRoles()) {

                    //recuperation nom du role dans la base de donnees
                    String nomRole = role.getName();
                    if (nomRole.startsWith("ROLE_")) {

                        //on ajout le nom du role
                        roles.add(nomRole);
                    }
                    else {
                        droits.add(nomRole);
                    }

                    //on ajout le nom du role dans la liste des role
                    roles.add(role.getName());
                }

                return LoginResponse.builder()
                        .email(user.getEmail())
                        .nom(user.getNom())
                        .prenom(user.getPrenom())
                        .token("toto")
                        .droits(droits)
                        .roles(roles)
                        .build();
            }

        }
        return null;
    }
}

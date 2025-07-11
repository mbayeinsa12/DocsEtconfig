package sn.edu.isep.dbe.DocsEtConfig.services;

import org.springframework.stereotype.Service;
import sn.edu.isep.dbe.DocsEtConfig.entities.User;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.LoginResponse;
import sn.edu.isep.dbe.DocsEtConfig.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse login(String username, String password) {
        boolean isAuthenticated = authenticateUser(username, password);
        if (isAuthenticated) {
            // Créer une réponse avec un token fictif pour l'exemple
            return new LoginResponse("qwertyuiopasdfghjklzxcvbnm122", username, "USER");
        }
        return null;
    }

    public boolean authenticateUser(String username, String password) {
        // Logique d'authentification à implémenter
        return true; // Temporaire pour test
    }

    public void save(User user) {
        userRepository.save(user);
    }
}

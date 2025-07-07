package sn.edu.isep.dbe.DocsEtConfig.services;

import org.springframework.stereotype.Service;
import sn.edu.isep.dbe.DocsEtConfig.entities.dto.LoginResponse;

@Service
public class UserService {

    public LoginResponse login(String username, String password) {
        boolean isAuthenticated = authenticateUser(username, password);
        if (isAuthenticated) {
            // Créer une réponse avec un token fictif pour l'exemple
            return new LoginResponse("token_example", username, "USER");
        }
        return null;
    }

    public boolean authenticateUser(String username, String password) {
        // Logique d'authentification à implémenter
        return true; // Temporaire pour test
    }
}

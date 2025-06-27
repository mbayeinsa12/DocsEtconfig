package sn.edu.isep.dbe.DocsEtConfig.entities.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {
    private String email;
    private String prenom;
    private String nom;
    private String token;
    private List<String> roles;
    private List<String> droits;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "email='" + email + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", token='" + token + '\'' +
                ", roles=" + roles +
                ", droits=" + droits +
                '}';
    }
}

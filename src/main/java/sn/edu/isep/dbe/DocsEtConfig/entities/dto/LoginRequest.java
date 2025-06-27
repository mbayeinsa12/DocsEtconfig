package sn.edu.isep.dbe.DocsEtConfig.entities.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String login;
    private String password;
}

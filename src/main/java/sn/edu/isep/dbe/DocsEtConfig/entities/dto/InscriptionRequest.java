package sn.edu.isep.dbe.DocsEtConfig.entities.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sn.edu.isep.dbe.DocsEtConfig.entities.Droit;
import sn.edu.isep.dbe.DocsEtConfig.entities.Role;
import java.util.List;
@Getter
@Setter

public class InscriptionRequest {
    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    private String adresse;

    private List<String> roles;


    private List<String> droits;

}


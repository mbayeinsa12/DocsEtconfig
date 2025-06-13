package sn.edu.isep.dbe.DocsEtConfig.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "magasin")
public class Magasin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(nullable = false)
    private String nom;
    private String adresse;
    private String description;
    private String Telephone;
}

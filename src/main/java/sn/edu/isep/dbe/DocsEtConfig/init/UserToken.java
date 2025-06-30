package sn.edu.isep.dbe.DocsEtConfig.init;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sn.edu.isep.dbe.DocsEtConfig.entities.User;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_token")
public class UserToken {
    @Id
    @Column(name = "token", nullable = false)
    private String token;
    @ManyToOne
    private User user;

    private Date notBsfore;
    private Date expiresAt;

}
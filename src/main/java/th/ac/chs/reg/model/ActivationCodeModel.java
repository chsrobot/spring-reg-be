package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "activation_code")
public class ActivationCodeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code",unique = true)
    private String code;
    @Column(name = "username")
    private String username;
}

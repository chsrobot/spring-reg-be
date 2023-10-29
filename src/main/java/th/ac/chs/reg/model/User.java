package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
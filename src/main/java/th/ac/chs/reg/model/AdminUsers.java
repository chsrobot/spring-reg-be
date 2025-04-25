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
public class AdminUsers extends BaseEntity implements Serializable {

    @Column(name = "email")
    private String email;

    @Column(name = "tel")
    private String tel;

    @Column(name = "identity_num")
    private String identity_num;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now().getEpochSecond();
    }
}
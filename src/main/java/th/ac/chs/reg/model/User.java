package th.ac.chs.reg.model;

        import jakarta.persistence.*;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

        import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "users")
public class User extends BaseEntity {

    @Column(name = "password")
    private String password;

    /*@PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }*/
}


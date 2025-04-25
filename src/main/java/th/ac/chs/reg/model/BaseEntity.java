package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", nullable = false, unique = true)
    String username;

    @Column(name = "created_at")
    Long createdAt;

    @Column(name = "updated_at")
    Long updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now().getEpochSecond();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }
}

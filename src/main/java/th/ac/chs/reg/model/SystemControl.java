package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "system_control")
public class SystemControl implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "status")
    private String status;
    @Column(name = "message")
    private Integer message;

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

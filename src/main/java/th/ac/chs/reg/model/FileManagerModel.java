package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "filemanagers")

public class FileManagerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="username")
    private String username;
    @Column(name="fileType")
    private String fileType;
    @Column(name="fileName")
    private String fileName;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now().getEpochSecond();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }
}

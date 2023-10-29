package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "username", nullable = false, unique = true)
    private String username;
}

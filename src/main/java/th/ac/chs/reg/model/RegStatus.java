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
public class RegStatus extends BaseEntity implements Serializable {

    @Column(name = "isSubmitSpecial")
    private Boolean isSubmitSpecial;

    @Column(name = "isSubmitNormal")
    private Boolean isSubmitNormal;

    @Column(name = "isCheckedSpecial")
    private Boolean isCheckedSpecial;

    @Column(name = "isCheckNormal")
    private Boolean isCheckNormal;

    @Column(name = "isPassSpecial")
    private Boolean isPassSpecial;

    @Column(name = "isPassNormal")
    private Boolean isPassNormal;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now().getEpochSecond();
    }
}
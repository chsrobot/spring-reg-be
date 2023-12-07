package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import th.ac.chs.reg.model.BaseEntity;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "status")
public class Status extends BaseEntity {

    @Column(name = "status_extra")
    private String statusExtra = "waiting";

    @Column(name = "status_normal")
    private String statusNormal = "waiting";

    @Column(name = "status_pay")
    private String statusPay = "waiting";

}

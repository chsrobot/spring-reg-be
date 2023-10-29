package th.ac.chs.reg.model.address;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import th.ac.chs.reg.model.BaseEntity;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "address")
public class Address extends BaseEntity {

    @Column(name = "parents_status", nullable = false)
    private String parentsStatus;

    @Column(name = "house_code", nullable = false)
    private Long houseCode;

    @Column(name = "house_num", nullable = false)
    private Long houseNum;

    @Column(name = "village_num")
    private Long villageNum;

    @Column(name = "village")
    private String village;

    @Column(name = "lane")
    private String lane;

    @Column(name = "road")
    private String road;

    @Column(name = "sub_district", nullable = false)
    private String subDistrict;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "house_phone", nullable = false)
    private Long housePhone;

    @Column(name = "phone_num", nullable = false)
    private Long phoneNum;

}

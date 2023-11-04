package th.ac.chs.reg.model;

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
    //confirmation

    @Column(name = "house_code", nullable = false)
    private Long houseCode;
    //registeration and confirmation

    @Column(name = "house_num", nullable = false)
    private Long houseNum;
    //registeration and confirmation

    @Column(name = "village_num")
    private Long villageNum;
    //registeration and confirmation

    @Column(name = "village")
    private String village;
    //registeration and confirmation

    @Column(name = "lane")
    private String lane;
    //registeration and confirmation

    @Column(name = "road")
    private String road;
    //registeration and confirmation

    @Column(name = "sub_district", nullable = false)
    private String subDistrict;
    //registeration and confirmation

    @Column(name = "district", nullable = false)
    private String district;
    //registeration and confirmation

    @Column(name = "province", nullable = false)
    private String province;
    //registeration and confirmation

    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    //registeration and confirmation

    @Column(name = "house_phone", nullable = false)
    private Long housePhone;
    //registeration and confirmation

    @Column(name = "phone_num", nullable = false)
    private Long phoneNum;
    //registeration and confirmation

}

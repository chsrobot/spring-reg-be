package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "user_data")
public class UserData extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "identity_num", nullable = false)
    private Long identityNum;

    @Column(name = "name_titleTH", nullable = false)
    private String nameTitleTH;

    @Column(name = "firstnameTH", nullable = false)
    private String firstNameTH;

    @Column(name = "lastnameTH", nullable = false)
    private String lastNameTH;

    @Column(name = "name_titleEN", nullable = false)
    private String nameTitleEN;

    @Column(name = "firstnameEN", nullable = false)
    private String firstNameEN;

    @Column(name = "lastnameEN", nullable = false)
    private String lastNameEN;

    @Column(name = "birth_day", nullable = false)
    private Long birthDay;

    @Column(name = "birth_month", nullable = false)
    private String birthMonth;

    @Column(name = "birth_year", nullable = false)
    private Long birthYear;

    @Column(name = "blood_type", nullable = false)
    private String bloodType;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "religion", nullable = false)
    private String religion;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "born_place", nullable = false)
    private String bornPlace;

    @Column(name = "born_province", nullable = false)
    private String bornProvince;

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

    @Column(name = "phone_num", nullable = false)
    private Long phoneNum;

    @Column(name = "updated_at")
    private Long updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }
}

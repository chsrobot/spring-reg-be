package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import th.ac.chs.reg.model.BaseEntity;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "user_data")
public class UserData extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    //registeration and confirmation

    @Column(name = "identity_num", nullable = false)
    private Long identityNum;
    //registeration and confirmation

    @Column(name = "name_title_th", nullable = false)
    private String nameTitleTH;
    //registeration and confirmation

    @Column(name = "firstname_th", nullable = false)
    private String firstNameTH;
    //registeration and confirmation

    @Column(name = "lastname_th", nullable = false)
    private String lastNameTH;
    //registeration and confirmation

    @Column(name = "name_title_en", nullable = false)
    private String nameTitleEN;
    //registeration and confirmation

    @Column(name = "firstname_en", nullable = false)
    private String firstNameEN;
    //registeration and confirmation

    @Column(name = "lastname_en", nullable = false)
    private String lastNameEN;
    //registeration and confirmation

    @Column(name = "birth_day", nullable = false)
    private Long birthDay;
    //registeration and confirmation

    @Column(name = "birth_month", nullable = false)
    private String birthMonth;
    //registeration and confirmation

    @Column(name = "birth_year", nullable = false)
    private Long birthYear;
    //registeration and confirmation

    @Column(name = "blood_type", nullable = false)
    private String bloodType;
    //registeration and confirmation

    @Column(name = "gender", nullable = false)
    private String gender;
    //registeration and confirmation

    @Column(name = "religion", nullable = false)
    private String religion;
    //registeration and confirmation

    @Column(name = "race", nullable = false)
    private String race;
    //registeration and confirmation

    @Column(name = "nationality", nullable = false)
    private String nationality;
    //registeration and confirmation

    @Column(name = "born_place", nullable = false)
    private String bornPlace;
    //registeration and confirmation

    @Column(name = "born_province", nullable = false)
    private String bornProvince;
    //registeration and confirmation

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

    @Column(name = "phone_num", nullable = false)
    private Long phoneNum;
    //registeration and confirmation
}

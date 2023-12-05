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
    private String identityNum;
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

    @Column(name = "house_code_now", nullable = false)
    private String houseCodeNow;
    //registeration and confirmation

    @Column(name = "house_num_now", nullable = false)
    private String houseNumNow;
    //registeration and confirmation

    @Column(name = "village_num_now")
    private String villageNumNow;
    //registeration and confirmation

    @Column(name = "village_now")
    private String villageNow;
    //registeration and confirmation

    @Column(name = "lane_now")
    private String laneNow;
    //registeration and confirmation

    @Column(name = "road_now")
    private String roadNow;
    //registeration and confirmation

    @Column(name = "sub_district_now", nullable = false)
    private String subDistrictNow;
    //registeration and confirmation

    @Column(name = "district_now", nullable = false)
    private String districtNow;
    //registeration and confirmation

    @Column(name = "province_now", nullable = false)
    private String provinceNow;
    //registeration and confirmation

    @Column(name = "postal_code_now", nullable = false)
    private String postalCodeNow;
    //registeration and confirmation

    @Column(name = "phone_num", nullable = false)
    private String phoneNum;
    //registeration and confirmation
}

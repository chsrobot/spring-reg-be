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

    @Column(name = "identity_num")
    private String identityNum;
    //registeration and confirmation

    @Column(name = "name_title_th")
    private String nameTitleTH;
    //registeration and confirmation

    @Column(name = "firstname_th")
    private String firstNameTH;
    //registeration and confirmation

    @Column(name = "lastname_th")
    private String lastNameTH;
    //registeration and confirmation

    @Column(name = "name_title_en")
    private String nameTitleEN;
    //registeration and confirmation

    @Column(name = "firstname_en")
    private String firstNameEN;
    //registeration and confirmation

    @Column(name = "lastname_en")
    private String lastNameEN;
    //registeration and confirmation

    @Column(name = "birth_day")
    private Long birthDay;
    //registeration and confirmation

    @Column(name = "birth_month")
    private String birthMonth;
    //registeration and confirmation

    @Column(name = "birth_year")
    private Long birthYear;
    //registeration and confirmation

    @Column(name = "blood_type")
    private String bloodType;
    //registeration and confirmation

    @Column(name = "gender")
    private String gender;
    //registeration and confirmation

    @Column(name = "religion")
    private String religion;
    //registeration and confirmation

    @Column(name = "race")
    private String race;
    //registeration and confirmation

    @Column(name = "nationality")
    private String nationality;
    //registeration and confirmation

    @Column(name = "born_place")
    private String bornPlace;
    //registeration and confirmation

    @Column(name = "born_province")
    private String bornProvince;
    //registeration and confirmation

    @Column(name = "house_code_now")
    private String houseCodeNow;
    //registeration and confirmation

    @Column(name = "house_num_now")
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

    @Column(name = "sub_district_now")
    private String subDistrictNow;
    //registeration and confirmation

    @Column(name = "district_now")
    private String districtNow;
    //registeration and confirmation

    @Column(name = "province_now")
    private String provinceNow;
    //registeration and confirmation

    @Column(name = "postal_code_now")
    private String postalCodeNow;
    //registeration and confirmation

    @Column(name = "phone_num")
    private String phoneNum;
    //registeration and confirmation

    @Column(name = "comment", nullable = false)
    private String comment;
    
}

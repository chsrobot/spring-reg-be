package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import th.ac.chs.reg.model.BaseEntity;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "parents_data")
public class ParentsData extends BaseEntity {

    @Column(name = "type_parent",nullable = false)
    private String typeParent;

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

    @Column(name = "identity_num")
    private String identityNum;
    //registeration and confirmation

    @Column(name = "relation")
    private String relation;
    //registeration and confirmation

    @Column(name = "age")
    private Long age;
    //registeration and confirmation
  
    @Column(name = "phone_num")
    private String phoneNum;
    //registeration and confirmation

    @Column(name = "email")
    private String email;
    //registeration and confirmation

    @Column(name = "career")
    private String career;
    //registeration and confirmation

    @Column(name = "position")
    private String position;
    //registeration and confirmation

    @Column(name = "salary")
    private String salary;
    //registeration and confirmation

    @Column(name = "office_num")
    private String officeNum;
    //registeration

    @Column(name = "village_num")
    private String villageNum;
    //registeration

    @Column(name = "lane")
    private String lane;
    //registeration

    @Column(name = "road")
    private String road;
    //registeration

    @Column(name = "sub_district")
    private String subDistrict;
    //registeration

    @Column(name = "district")
    private String district;
    //registeration

    @Column(name = "province")
    private String province;
    //registeration

    @Column(name = "postal_code")
    private String postalCode;
    //registeration

}

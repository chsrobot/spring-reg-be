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

    @Column(name = "name_title_th", nullable = false)
    private String nameTitleTH;

    @Column(name = "firstname_th", nullable = false)
    private String firstNameTH;

    @Column(name = "lastname_th", nullable = false)
    private String lastNameTH;

    @Column(name = "name_title_en", nullable = false)
    private String nameTitleEN;

    @Column(name = "firstname_en", nullable = false)
    private String firstNameEN;

    @Column(name = "lastname_en", nullable = false)
    private String lastNameEN;

    @Column(name = "identity_num", nullable = false)
    private Long identityNum;

    @Column(name = "relation", nullable = false)
    private String relation;

    @Column(name = "age", nullable = false)
    private Long age;

    @Column(name = "phone_num", nullable = false)
    private Long phoneNum;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "career")
    private String career;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "office_num", nullable = false)
    private Long officeNum;

    @Column(name = "village_num")
    private Long villageNum;

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

}

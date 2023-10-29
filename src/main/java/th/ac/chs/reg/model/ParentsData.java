package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "parents_data")
public class ParentsData extends BaseEntity {

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

    @Column(name = "updated_at")
    private Long updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }
}

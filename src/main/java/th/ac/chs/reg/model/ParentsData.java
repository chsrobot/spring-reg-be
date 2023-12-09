package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import th.ac.chs.reg.model.BaseEntity;

import java.time.Instant;

@Data
@Entity(name = "parents_data")
public class ParentsData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "type_parent",nullable = false)
    private String typeParent;

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

    @Column(name = "identity_num", nullable = false)
    private String identityNum;
    //registeration and confirmation

    @Column(name = "relation")
    private String relation;
    //registeration and confirmation

    @Column(name = "age", nullable = false)
    private Long age;
    //registeration and confirmation

    @Column(name = "phone_num", nullable = false)
    private String phoneNum;
    //registeration and confirmation

    @Column(name = "email", nullable = false, unique = true)
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

    @Column(name = "created_at")
    Long createdAt;

    @Column(name = "updated_at")
    Long updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now().getEpochSecond();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }

}

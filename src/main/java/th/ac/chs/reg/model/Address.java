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

    @Column(name = "parents_status")
    private String parentsStatus;
    //confirmation

    @Column(name = "house_code")
    private String houseCode;
    //registeration and confirmation

    @Column(name = "house_num")
    private String houseNum;
    //registeration and confirmation

    @Column(name = "village_num")
    private String villageNum;
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

    @Column(name = "sub_district")
    private String subDistrict;
    //registeration and confirmation

    @Column(name = "district")
    private String district;
    //registeration and confirmation

    @Column(name = "province")
    private String province;
    //registeration and confirmation

    @Column(name = "postal_code")
    private String postalCode;
    //registeration and confirmation

    @Column(name = "house_phone")
    private String housePhone;
    //registeration and confirmation

    @Column(name = "phone_num")
    private String phoneNum;
    //registeration and confirmation

    @Column(name = "check_sub_district")
    boolean checkSubDistrict = false;
    public boolean isCheckSubDistrict() {
        if (subDistrict.equals("ในเมือง")){
            checkSubDistrict = true;
        }
        return false;
    }

    @Column(name = "check_district")
    boolean checkDistrict = false;
    public boolean isCheckDistrict() {
        if (district.equals("เมืองพิษณุโลก")){
            checkDistrict = true;
        }
        return false;
    }

    @Column(name = "check_province")
    boolean checkProvince = false;
    public boolean isCheckProvince() {
        if (province.equals("พิษณุโลก")){
            checkProvince = true;
        }
        return false;
    }

}

package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import th.ac.chs.reg.model.BaseEntity;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "education")
public class Education extends BaseEntity {

    @Column(name = "extra_type")
    private String extraType;
    //registeration and confirmation

    @Column(name = "typeroom1")
    private String typeRoom1;
    //registeration and confirmation

    @Column(name = "typeroom2")
    private String typeRoom2;
    //registeration

    @Column(name = "typeroom3")
    private String typeRoom3;
    //registeration

    @Column(name = "last_school")
    private String lastSchool;
    //registeration and confirmation

    @Column(name = "district")
    private String district;
    //registeration and confirmation

    @Column(name = "province")
    private String province;
    //registeration and confirmation

    @Column(name = "grade_level")
    private String gradeLevel;
    //registeration and confirmation

    @Column(name = "student_id")
    private String studentId;
    //registeration and confirmation

    @Column(name = "gpa")
    private String gpa;
    //registeration and confirmation

    @Column(name = "school1")
    private String reserveSchool1;
    //registeration

    @Column(name = "school2")
    private String reserveSchool2;
    //registeration

    @Column(name = "school3")
    private String reserveSchool3;
    //registeration

    @Column(name = "talent")
    private String talent;
    //registeration and confirmation

}

package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "education")
public class Education extends BaseEntity {

    @Column(name = "typeroom")
    private String typeRoom;

    @Column(name = "typeroom1")
    private String typeRoom1;

    @Column(name = "typeroom2")
    private String typeRoom2;

    @Column(name = "typeroom3")
    private String typeRoom3;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "grade_level", nullable = false)
    private String gradeLevel;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "gpa", nullable = false)
    private Long gpa;

    @Column(name = "school1")
    private String reserveSchool1;

    @Column(name = "school2")
    private String reserveSchool2;

    @Column(name = "school3")
    private String reserveSchool3;

    @Column(name = "talent")
    private String talent;

    @Column(name = "updated_at")
    private Long updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }
}

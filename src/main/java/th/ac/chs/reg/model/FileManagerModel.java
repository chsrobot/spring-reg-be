package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "filemanagers")

public class FileManagerModel extends BaseEntity implements Serializable {
    @Column(name="username")
    private String username;
    @Column(name="fileType")
    private String fileType;
    @Column(name="fileName")
    private String fileName;
}

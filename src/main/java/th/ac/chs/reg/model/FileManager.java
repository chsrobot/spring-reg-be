package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "filemanagers")
public class FileManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fileType;
    private String fileName;
}

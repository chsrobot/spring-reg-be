package th.ac.chs.reg.model;

import jakarta.persistence.*;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "navbar_global")
public class NavigationBar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "label")
    private String label;
    @Column(name = "link")
    private String link;
    @Column(name = "permission")
    private Integer permission;
}

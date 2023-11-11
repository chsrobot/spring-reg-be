package th.ac.chs.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.chs.reg.model.ParentsData;
import th.ac.chs.reg.service.ParentsDataService;

import java.util.List;

@RestController
@RequestMapping("/api/parents-data")
public class ParentsDataController {

    private final ParentsDataService parentsDataService;

    @Autowired
    public ParentsDataController(ParentsDataService parentsDataService) {
        this.parentsDataService = parentsDataService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ParentsData>> getAllParentsData() {
        return ResponseEntity.ok(parentsDataService.getAllParentsData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentsData> getParentsDataById(@PathVariable Long id) {
        ParentsData parentsData = parentsDataService.getParentsDataById(id);
        return ResponseEntity.ok(parentsData);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<ParentsData>> getParentsDataByUsername(@PathVariable String username) {
        List<ParentsData> parentsDataList = parentsDataService.getParentsDataByUsername(username);
        return ResponseEntity.ok(parentsDataList);
    }

    @GetMapping("/{username}/{parentType}")
    public ResponseEntity<ParentsData> getParentsDataByUsernameAndTypeParent(@PathVariable String username,
                                                                             @PathVariable String parentType) {
        ParentsData parentsData = parentsDataService.getParentsDataByUsernameAndTypeParent(username, parentType);
        return ResponseEntity.ok(parentsData);
    }

    @PostMapping("/")
    public ResponseEntity<ParentsData> saveParentsData(@RequestBody ParentsData parentsData) {
        ParentsData savedParentsData = parentsDataService.saveParentsData(parentsData);
        return ResponseEntity.ok(savedParentsData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParentsData(@PathVariable Long id) {
        parentsDataService.deleteParentsData(id);
        return ResponseEntity.noContent().build();
    }

}

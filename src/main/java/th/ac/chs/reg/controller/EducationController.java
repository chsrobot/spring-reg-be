package th.ac.chs.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.chs.reg.model.Education;
import th.ac.chs.reg.service.EducationService;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        return ResponseEntity.ok(educationService.getAllEducations());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Education> getEducationByUsername(@PathVariable String username) {
        Education education = educationService.getEducationByUsername(username);
        return ResponseEntity.ok(education);
    }

    @PostMapping
    public ResponseEntity<Education> saveEducation(@RequestBody Education education) {
        Education savedEducation = educationService.saveEducation(education);
        return ResponseEntity.ok(savedEducation);
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity<Void> deleteEducation(@PathVariable String username) {
        educationService.deleteEducationByUsername(username);
        return ResponseEntity.noContent().build();
    }
}

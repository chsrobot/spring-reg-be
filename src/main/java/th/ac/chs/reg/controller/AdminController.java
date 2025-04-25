package th.ac.chs.reg.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.chs.reg.service.AdminService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Map<String, Object>>> getAllEducations() {
        return ResponseEntity.ok(adminService.getAllUserDataWithEducation());
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Map<String, Object>>> getAllEducations(@PathVariable String username) {
        return ResponseEntity.ok(Collections.singletonList(adminService.getUserDataWithEducationByUsername(username)));
    }

}

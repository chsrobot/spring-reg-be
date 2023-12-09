package th.ac.chs.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.chs.reg.model.RegStatus;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.service.RegStatusService;
import th.ac.chs.reg.service.UserDataService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class RegStatusController {

    @Autowired
    private RegStatusService regStatusService;

    @GetMapping("/status")
    public List<RegStatus> getAllUserData() {
        return regStatusService.getAllUserData();
    }

    @GetMapping("/status/{username}")
    public RegStatus getUserDataByUsername(@PathVariable String username) {
        return regStatusService.getStatusByUsername(username);
    }

    @PostMapping("/status")
    public RegStatus createUser(@RequestBody UserData userData) {
        return regStatusService.createStatus(userData);
    }

    @PutMapping("/status/{username}")
    public RegStatus updateUser(@PathVariable String username, @RequestBody RegStatus regStatus) {
        return regStatusService.putStatus(username,regStatus);
    }

    @DeleteMapping("/status/{id}")
    public void deleteUser(@PathVariable Long id) {
        regStatusService.deleteUser(id);
    }
}

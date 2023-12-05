package th.ac.chs.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.service.UserDataService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping("/userdata")
    public List<UserData> getAllUserData() {
        return userDataService.getAllUserData();
    }

    @GetMapping("/userdata/{username}")
    public UserData getUserDataByUsername(@PathVariable String username) {
        return userDataService.getUserDataByUsername(username);
    }

    @PostMapping("/userdata")
    public UserData createUser(@RequestBody UserData userData) {
        return userDataService.createUser(userData);
    }

    @PutMapping("/userdata/{username}")
    public UserData updateUser(@PathVariable String username, @RequestBody UserData userData) {
        return null;
    }

    @DeleteMapping("/userdata/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDataService.deleteUser(id);
    }
}

package th.ac.chs.reg.controller;

import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/userdata")
    public List<UserData> getAllUserData(HttpServletRequest request) {
//        String customHeaderValue = (String) request.getAttribute("Custom-Header");
//        System.out.println("Custom Header Value: " + customHeaderValue);
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
        return userDataService.putUser(username,userData);
    }

    @DeleteMapping("/userdata/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDataService.deleteUser(id);
    }
}

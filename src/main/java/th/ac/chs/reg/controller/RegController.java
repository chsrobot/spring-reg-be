package th.ac.chs.reg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import th.ac.chs.reg.model.User;
import th.ac.chs.reg.service.UserService;

@RestController
@RequestMapping("/api")
public class RegController {
    private final UserService userService;

    public RegController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws Exception {

        try {
            userService.registerUser(user);
            return new ResponseEntity<>("Created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Created Failed", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Its works with docker", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            userService.loginUser(user);
            return new ResponseEntity<>("Login Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Login Failed", HttpStatus.EXPECTATION_FAILED);
        }
    }



}

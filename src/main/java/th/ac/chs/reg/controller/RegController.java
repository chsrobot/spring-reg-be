package th.ac.chs.reg.controller;

import ch.qos.logback.core.model.Model;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import th.ac.chs.reg.model.AdminUsers;
import th.ac.chs.reg.model.User;
import th.ac.chs.reg.model.ResponseModel;
import th.ac.chs.reg.service.ActivationCodeService;
import th.ac.chs.reg.service.AdminUserService;
import th.ac.chs.reg.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RegController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private ActivationCodeService activationCodeService;

    @GetMapping("/register")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/admin_register")
    public List<AdminUsers> getAllAdminUsers() {
        return adminUserService.findAllAdminUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws Exception {
        try {
            userService.registerUser(user);
            ResponseModel responseModel = new ResponseModel("Created");
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            ResponseModel responseModel = new ResponseModel("Invalid Activation Code or Activation Code Has Been Used");
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ResponseModel responseModel = new ResponseModel("Conflict");
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/admin_register")
    public ResponseEntity<String> registerAdminUser(@RequestBody AdminUsers adminUsers) throws Exception {
        try {
            adminUserService.registerAdminUser(adminUsers);
            ResponseModel responseModel = new ResponseModel("Created");
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            ResponseModel responseModel = new ResponseModel("Invalid Activation Code or Activation Code Has Been Used");
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ResponseModel responseModel = new ResponseModel("Conflict");
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Its works with docker", HttpStatus.OK);
    }

    @GetMapping("/makecode")
    public ResponseEntity<String> makecode() throws Exception {
        return new ResponseEntity<>(activationCodeService.createActivationCode(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public  ResponseEntity<String> loginUser(@RequestBody User user){
        try{
            User logged_inUser = userService.loginUser(user);
            return new ResponseEntity<>(logged_inUser.toString(), HttpStatus.OK);
        }
        catch (Exception e){
            ResponseModel responseModel = new ResponseModel("NONONO");
            return new ResponseEntity<>("responseModel",HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/login")
    public  ResponseEntity<String> loginAdminUser(@RequestBody AdminUsers adminUsers){
        try{
            AdminUsers logged_inUser = adminUserService.loginAdminUser(adminUsers);
            return new ResponseEntity<>(logged_inUser.toString(), HttpStatus.OK);
        }
        catch (Exception e){
            ResponseModel responseModel = new ResponseModel("NONONO");
            return new ResponseEntity<>("responseModel",HttpStatus.UNAUTHORIZED);
        }
    }


}
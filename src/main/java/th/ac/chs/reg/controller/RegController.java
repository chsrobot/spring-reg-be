package th.ac.chs.reg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private static final Logger logger = LoggerFactory.getLogger(RegController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private ActivationCodeService activationCodeService;

    @GetMapping("/register")
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userService.findAllUsers();
    }

    @GetMapping("/admin_register")
    public List<AdminUsers> getAllAdminUsers() {
        logger.info("Fetching all admin users");
        return adminUserService.findAllAdminUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws Exception {
        try {
            userService.registerUser(user);
            ResponseModel responseModel = new ResponseModel("Created");
            logger.info("User registered successfully");
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            ResponseModel responseModel = new ResponseModel("Invalid Activation Code or Activation Code Has Been Used");
            logger.error("Error registering user: {}", e.getMessage());
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ResponseModel responseModel = new ResponseModel("Conflict");
            logger.error("Conflict while registering user: {}", e.getMessage());
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/admin_register")
    public ResponseEntity<String> registerAdminUser(@RequestBody AdminUsers adminUsers) throws Exception {
        try {
            adminUserService.registerAdminUser(adminUsers);
            ResponseModel responseModel = new ResponseModel("Created");
            logger.info("Admin user registered successfully");
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            ResponseModel responseModel = new ResponseModel("Invalid Activation Code or Activation Code Has Been Used");
            logger.error("Error registering admin user: {}", e.getMessage());
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ResponseModel responseModel = new ResponseModel("Conflict");
            logger.error("Conflict while registering admin user: {}", e.getMessage());
            return new ResponseEntity<>(responseModel.toString(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        logger.info("Hello endpoint called");
        return new ResponseEntity<>("It works with docker", HttpStatus.OK);
    }

    @GetMapping("/makecode")
    public ResponseEntity<String> makecode() throws Exception {
        logger.info("Creating activation code");
        return new ResponseEntity<>(activationCodeService.createActivationCode(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            User logged_inUser = userService.loginUser(user);
            logger.info("User logged in successfully: {}", logged_inUser.getUsername());
            return new ResponseEntity<>(new ResponseModel("OK").toString(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error logging in user: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseModel("Unauthorized").toString(), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/admin_login")
    public ResponseEntity<String> loginAdminUser(@RequestBody AdminUsers adminUsers) {
        try {
            AdminUsers logged_inUser = adminUserService.loginAdminUser(adminUsers);
            logger.info("Admin user logged in successfully: {}", logged_inUser.getUsername());
            return new ResponseEntity<>(new ResponseModel("OK").toString(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error logging in admin user: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseModel("Unauthorized").toString(), HttpStatus.UNAUTHORIZED);
        }
    }
}

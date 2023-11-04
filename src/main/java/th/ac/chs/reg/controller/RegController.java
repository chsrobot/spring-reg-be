package th.ac.chs.reg.controller;

import ch.qos.logback.core.model.Model;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import th.ac.chs.reg.model.User;
import th.ac.chs.reg.service.ActivationCodeService;
import th.ac.chs.reg.service.UserService;

@RestController
@RequestMapping("/api")
public class RegController {
    @Autowired
    private UserService userService;

    @Autowired
    private ActivationCodeService activationCodeService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws Exception {

        try{
            userService.registerUser(user);
            return new ResponseEntity<>("Created" , HttpStatus.CREATED);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>("Invalid Activation Code or Activation Code Has Been Used",HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity<>("Conflict",HttpStatus.CONFLICT);
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
            userService.loginUser(user);
            return new ResponseEntity<>("OK" , HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("NONONO",HttpStatus.UNAUTHORIZED);
        }
    }


}
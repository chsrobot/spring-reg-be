package th.ac.chs.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.chs.reg.model.SystemControl;
import th.ac.chs.reg.repository.SystemControlRepository;
import th.ac.chs.reg.service.ActivationCodeService;
import th.ac.chs.reg.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SystemController {

    @Autowired
    private SystemControlRepository systemControlRepository;

    @GetMapping("/systemcontrol/{type}")
    public ResponseEntity<String> getsystemcontrol(@PathVariable String type){
        return new ResponseEntity<String>(String.valueOf(systemControlRepository.findByType(type)),HttpStatus.OK);
    }
}

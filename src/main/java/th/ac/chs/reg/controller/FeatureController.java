package th.ac.chs.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.chs.reg.model.NavigationBar;
import th.ac.chs.reg.repository.NavigationBarRepository;
import th.ac.chs.reg.repository.UserRepository;
import th.ac.chs.reg.service.ActivationCodeService;
import th.ac.chs.reg.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeatureController {
    @Autowired
    private UserService userService;

    @Autowired
    private ActivationCodeService activationCodeService;

    @Autowired
    private NavigationBarRepository navigationBarRepository;

    @GetMapping("/navbar/global")
    public ResponseEntity<List> navbarGlobal(){
        return new ResponseEntity<List>(navigationBarRepository.findAll(),HttpStatus.OK);
    }
    @PostMapping("/navbar/global")
    public ResponseEntity<NavigationBar> addNavigationBar(@RequestBody NavigationBar navigationBar) {
        NavigationBar savedNavigationBar = navigationBarRepository.save(navigationBar);
        return new ResponseEntity<>(savedNavigationBar, HttpStatus.CREATED);
    }
    @PutMapping("/navbar/global/{id}")
    public ResponseEntity<NavigationBar> updateNavigationBar(
            @PathVariable Long id, @RequestBody NavigationBar updatedNavigationBar) {
    NavigationBar existingNavigationBar =
        navigationBarRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("NavigationBar not found with id " + id));

        existingNavigationBar.setLabel(updatedNavigationBar.getLabel());
        existingNavigationBar.setLink(updatedNavigationBar.getLink());
        existingNavigationBar.setPermission(updatedNavigationBar.getPermission());

        navigationBarRepository.save(existingNavigationBar);
        return new ResponseEntity<>(updatedNavigationBar, HttpStatus.OK);
    }
    @DeleteMapping("/navbar/global/{id}")
    public ResponseEntity<Void> deleteNavigationBar(@PathVariable Long id) {
    NavigationBar navigationBar =
        navigationBarRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("NavigationBar not found with id " + id));

        navigationBarRepository.delete(navigationBar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.ResponseModel;
import th.ac.chs.reg.model.User;
import th.ac.chs.reg.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivationCodeService activationCodeService;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) throws Exception {
        try {
            if (userRepository.findByUsername(user.getUsername()) != null) {
                throw new Exception("Username already exists");
            }

            String code = activationCodeService.checkAndTestCode(user.getUsername(), user.getActivationCode());

            user.setUsername(user.getUsername());
            user.setActivationCode(user.getActivationCode());
            user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
            return userRepository.save(user);
        }
        catch (RuntimeException e){
            throw new RuntimeException(e);
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }

    public User loginUser(User user) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        try{
            User checkuser = userRepository.findByUsername(user.getUsername());
            if(passwordEncoder.matches(user.getPassword() , checkuser.getPassword())){
                return checkuser;
            }
            else{
                throw new Exception("Invalid Credential");
            }
        }
        catch (Exception e){
            throw new Exception("Invalid Credential");
        }
    }
}

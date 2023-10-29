package th.ac.chs.reg.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.User;
import th.ac.chs.reg.repository.UserRepository;

@Service
public class UserService {
    //@Autowired
    private UserRepository userRepository;

    private UserService userService;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginUser(User user) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        try{

            if (user == null) {
                throw new Exception("null.user");
            }

            if (user.getUsername() == null) {
                throw new Exception("null.username");
            }

            if (user.getPassword() == null) {
                throw new Exception("null.password");
            }

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

    public User registerUser(User user) throws Exception {
        try {
            if (user == null) {
                throw new Exception("null.user");
            }

            if (user.getUsername() == null) {
                throw new Exception("null.username");
            }

            /*if (user.getEmail() == null) {
                throw new Exception("null.email");
            }*/

            if (user.getPassword() == null) {
                throw new Exception("null.password");
            }

            if (userRepository.findByUsername(user.getUsername()) != null) {
                throw new Exception("Username already exists");
            }
            user.setUsername(user.getUsername());
            user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
            return userRepository.save(user);
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }



}

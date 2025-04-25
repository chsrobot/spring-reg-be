package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.AdminUsers;
import th.ac.chs.reg.model.User;
import th.ac.chs.reg.repository.AdminUserRepository;
import th.ac.chs.reg.repository.UserRepository;

import java.util.List;

@Service
public class AdminUserService {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private ActivationCodeService activationCodeService;

    public List<AdminUsers> findAllAdminUsers() {
        return adminUserRepository.findAll();
    }

    public AdminUsers registerAdminUser(AdminUsers adminUsers) throws Exception {
        try {
            if (adminUserRepository.findByUsername(adminUsers.getUsername()) != null) {
                throw new Exception("Username already exists");
            }

            adminUsers.setUsername(adminUsers.getUsername());
            adminUsers.setPassword(BCrypt.hashpw(adminUsers.getPassword(),BCrypt.gensalt()));
            return adminUserRepository.save(adminUsers);
        }
        catch (RuntimeException e){
            throw new RuntimeException(e);
        }
        catch (Exception e){
            throw new Exception(e);
        }
    }

    public AdminUsers loginAdminUser(AdminUsers adminUsers) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        try{
            AdminUsers checkuser = adminUserRepository.findByUsername(adminUsers.getUsername());
            if(passwordEncoder.matches(adminUsers.getPassword() , checkuser.getPassword())){
                System.out.println("YOOOOOOOOOOOOOOOO " + checkuser);
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

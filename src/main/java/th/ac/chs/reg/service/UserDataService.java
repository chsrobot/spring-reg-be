package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.repository.UserDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public List<UserData> getAllUserData() {
        return userDataRepository.findAll();
    }

    public UserData getUserDataByUsername(String username) {
        return userDataRepository.findByUsername(username);
    }

    public UserData createUser(UserData userData) {
        return userDataRepository.save(userData);
    }

    public UserData updateUser(Long id, UserData userData) {
        return null;
    }

    public void deleteUser(Long id) {
        userDataRepository.deleteById(id);
    }
}

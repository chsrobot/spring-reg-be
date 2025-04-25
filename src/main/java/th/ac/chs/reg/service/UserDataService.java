package th.ac.chs.reg.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.repository.UserDataRepository;

import java.io.Console;
import java.lang.reflect.Field;
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

    public UserData putUser(String username, UserData userData) {
        UserData existuserdata = userDataRepository.findByUsername(username);

        if (existuserdata == null) {
            existuserdata = new UserData();
            existuserdata.setUsername(username);
        }

        Field[] fields = UserData.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(userData);
                if (value != null) {
                    field.set(existuserdata, value);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }

        return userDataRepository.save(existuserdata);
    }


    public void deleteUser(Long id) {
        userDataRepository.deleteById(id);
    }


}

package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.RegStatus;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.repository.RegStatusRepository;
import th.ac.chs.reg.repository.UserDataRepository;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class RegStatusService {

    @Autowired
    private RegStatusRepository regStatusRepository;

    public List<RegStatus> getAllUserData() {
        return regStatusRepository.findAll();
    }

    public RegStatus getStatusByUsername(String username) {
        return regStatusRepository.findByUsername(username);
    }

    public RegStatus createStatus(RegStatus regStatus) {
        return regStatusRepository.save(regStatus);
    }

    public RegStatus putStatus(String username, RegStatus userData) {
        RegStatus existStatus = regStatusRepository.findByUsername(username);

        if (existStatus == null) {
            existStatus = new RegStatus();
            existStatus.setUsername(username);
        }

        Field[] fields = RegStatus.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(userData);
                if (value != null) {
                    field.set(existStatus, value);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }

        return regStatusRepository.save(existStatus);
    }


    public void deleteUser(Long id) {
        regStatusRepository.deleteById(id);
    }


}

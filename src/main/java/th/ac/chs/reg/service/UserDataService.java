package th.ac.chs.reg.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.repository.UserDataRepository;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
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

    public UserData updateUser(Long id, UserData updatedUserData) {
        Optional<UserData> optionalUserData = userDataRepository.findById(id);

        if (optionalUserData.isPresent()) {
            UserData existingUserData = optionalUserData.get();
            BeanUtils.copyProperties(updatedUserData, existingUserData, "id");
            return userDataRepository.save(existingUserData);
        } else {
            return null;
        }
    }

    public UserData partialUpdateUser(Long id, UserData partialUserData) {
        Optional<UserData> optionalUserData = userDataRepository.findById(id);

        if (optionalUserData.isPresent()) {
            UserData existingUserData = optionalUserData.get();
            BeanUtils.copyProperties(partialUserData, existingUserData, getNullPropertyNames(partialUserData));
            return userDataRepository.save(existingUserData);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userDataRepository.deleteById(id);
    }

    private String[] getNullPropertyNames(UserData source) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] descriptors = beanWrapper.getPropertyDescriptors();

        List<String> nullProperties = new ArrayList<>();
        for (PropertyDescriptor descriptor : descriptors) {
            String propertyName = descriptor.getName();
            Object propertyValue = beanWrapper.getPropertyValue(propertyName);
            if (propertyValue == null) {
                nullProperties.add(propertyName);
            }
        }

        return nullProperties.toArray(new String[0]);
    }
}
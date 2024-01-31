package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.RegStatus;
import th.ac.chs.reg.model.Status;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.model.Education;
import th.ac.chs.reg.repository.EducationRepository;
import th.ac.chs.reg.repository.RegStatusRepository;
import th.ac.chs.reg.repository.StatusRepository;
import th.ac.chs.reg.repository.UserDataRepository;

import java.util.*;

@Service
public class AdminService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private RegStatusRepository regStatusRepository;

    public List<Map<String, Object>> getAllUserDataWithEducation() {
        List<UserData> userDataList = userDataRepository.findAll();
        List<Education> educationList = educationRepository.findAll();
        List<Map<String, Object>> joinedData = joinData(userDataList, educationList);
        return joinedData;
    }

    public Map<String, Object> getUserDataWithEducationByUsername(String username) {
        UserData userData = userDataRepository.findByUsername(username);
        Education education = educationRepository.findByUsername(username);

        if (userData != null && education != null) {
            Map<String, Object> userDataWithEducation = new HashMap<>();
            userDataWithEducation.put("userData", userData);
            userDataWithEducation.put("education", education);

            return userDataWithEducation;
        } else {
            return Collections.emptyMap();
        }
    }

    private List<Map<String, Object>> joinData(List<UserData> userDataList, List<Education> educationList) {
        List<Map<String, Object>> joinedData = new ArrayList<>();
        for (UserData userData : userDataList) {
            for (Education education : educationList) {
                if (userData.getUsername().equals(education.getUsername())) {
                    Map<String, Object> combinedData = new HashMap<>();
                    combinedData.put("username", userData.getUsername());
                    combinedData.put("userData", userData);
                    combinedData.put("education", education);

                    joinedData.add(combinedData);
                }
            }
        }

        return joinedData;
    }
}

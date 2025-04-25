package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.Education;
import th.ac.chs.reg.model.ParentsData;
import th.ac.chs.reg.repository.EducationRepository;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    public Education getEducationByUsername(String username) {
        return educationRepository.findByUsername(username);
    }

    public Education saveEducation(Education education) {
        return educationRepository.save(education);
    }


    public Education putEducation(String username, Education education){
        Education existEducation = educationRepository.findByUsername(username);

        if (existEducation == null) {
            existEducation = new Education();
            existEducation.setUsername(username);
        }

        Field[] fields = ParentsData.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(existEducation);
                if (value != null) {
                    field.set(existEducation, value);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }


        return educationRepository.save(existEducation);
    }

    public void deleteEducationByUsername(String username) {
        Education education = educationRepository.findByUsername(username);
        if (education != null) {
            educationRepository.delete(education);
        }
    }
}

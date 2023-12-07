package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.Education;
import th.ac.chs.reg.repository.EducationRepository;

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

    public void deleteEducationByUsername(String username) {
        Education education = educationRepository.findByUsername(username);
        if (education != null) {
            educationRepository.delete(education);
        }
    }
}

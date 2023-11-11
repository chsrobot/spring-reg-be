package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.ParentsData;
import th.ac.chs.reg.repository.ParentsDataRepository;

import java.util.List;

@Service
public class ParentsDataService {

    private final ParentsDataRepository parentsDataRepository;

    @Autowired
    public ParentsDataService(ParentsDataRepository parentsDataRepository) {
        this.parentsDataRepository = parentsDataRepository;
    }

    public List<ParentsData> getAllParentsData() {
        return parentsDataRepository.findAll();
    }

    public ParentsData getParentsDataById(Long id) {
        return parentsDataRepository.findById(id).orElse(null);
    }

    public List<ParentsData> getParentsDataByUsername(String username) {
        return parentsDataRepository.findByUsername(username);
    }

    public ParentsData getParentsDataByUsernameAndTypeParent(String username, String parentType) {
        return parentsDataRepository.findByUsernameAndTypeParent(username, parentType);
    }

    public ParentsData saveParentsData(ParentsData parentsData) {
        return parentsDataRepository.save(parentsData);
    }

    public void deleteParentsData(Long id) {
        parentsDataRepository.deleteById(id);
    }
}

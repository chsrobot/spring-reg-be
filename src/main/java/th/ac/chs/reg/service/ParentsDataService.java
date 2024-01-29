package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.ParentsData;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.repository.ParentsDataRepository;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class ParentsDataService {

    @Autowired
    private ParentsDataRepository parentsDataRepository;

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

    public ParentsData putParentsData(String username,String parentType,ParentsData parentsData){
        ParentsData existParentData = parentsDataRepository.findByUsernameAndTypeParent(username,parentType);

        if (existParentData == null) {
            existParentData = new ParentsData();
            existParentData.setUsername(username);
        }

        Field[] fields = ParentsData.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(parentsData);
                if (value != null) {
                    field.set(existParentData, value);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }


        return parentsDataRepository.save(existParentData);
    }
    public void deleteParentsData(Long id) {
        parentsDataRepository.deleteById(id);
    }
}

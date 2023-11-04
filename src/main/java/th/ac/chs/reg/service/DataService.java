package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.Address;
import th.ac.chs.reg.model.Education;
import th.ac.chs.reg.model.ParentsData;
import th.ac.chs.reg.model.UserData;
import th.ac.chs.reg.repository.AddressRepository;
import th.ac.chs.reg.repository.EducationRepository;
import th.ac.chs.reg.repository.UserDataRepository;
import th.ac.chs.reg.repository.ParentsDataReporitory;

@Service
public class DataService {
    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private ParentsDataReporitory parentsDataRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EducationRepository educationRepository;

    public UserData addItem(UserData userData) {
        return userDataRepository.save(userData);
    }

    public ParentsData addItem(ParentsData parentsData) {
        return parentsDataRepository.save(parentsData);
    }

    public Address addItem(Address address) {
        return addressRepository.save(address);
    }

    public Education addItem(Education education) {
        return educationRepository.save(education);
    }
}

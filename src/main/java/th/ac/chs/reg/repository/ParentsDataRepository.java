package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.ParentsData;
import java.util.List;

public interface ParentsDataRepository extends JpaRepository<ParentsData, Long> {
    List<ParentsData> findByUsername(String username);
    ParentsData findByUsernameAndTypeParent(String username, String parentType);
}

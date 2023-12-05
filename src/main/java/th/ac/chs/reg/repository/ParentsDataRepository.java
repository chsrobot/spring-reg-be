package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.ParentsData;

public interface ParentsDataRepository extends JpaRepository<ParentsData, Long> {
    ParentsData findByUsername(String username);
}

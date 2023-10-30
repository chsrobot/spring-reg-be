package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.parents_data.ParentsData;

public interface ParentsDataReporitory extends JpaRepository<ParentsData, Long> {
    ParentsData findByUsername(String username);
}

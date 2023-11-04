package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
    Education findByUsername(String username);
}

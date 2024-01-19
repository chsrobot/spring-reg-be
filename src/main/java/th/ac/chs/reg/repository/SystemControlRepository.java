package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.SystemControl;

import java.util.List;

public interface SystemControlRepository extends JpaRepository<SystemControl, Long> {
    SystemControl findByType(String type);
}

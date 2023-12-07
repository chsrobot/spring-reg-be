package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByUsername(String username);
}

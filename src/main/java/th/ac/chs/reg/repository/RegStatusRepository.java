package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.RegStatus;
import th.ac.chs.reg.model.User;
public interface RegStatusRepository extends JpaRepository<RegStatus, Long> {
    RegStatus findByUsername(String username);
}
package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
    UserData findByUsername(String username);
}


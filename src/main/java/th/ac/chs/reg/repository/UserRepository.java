package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

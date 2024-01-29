package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.AdminUsers;

public interface AdminUserRepository extends JpaRepository<AdminUsers, Long> {
    AdminUsers findByUsername(String username);
}

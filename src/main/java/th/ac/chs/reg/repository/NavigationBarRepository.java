package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.NavigationBar;

import java.util.List;

public interface NavigationBarRepository extends JpaRepository<NavigationBar, Long> {
    List<NavigationBar> findAll();
}

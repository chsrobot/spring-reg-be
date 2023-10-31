package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByUsername(String username);
}

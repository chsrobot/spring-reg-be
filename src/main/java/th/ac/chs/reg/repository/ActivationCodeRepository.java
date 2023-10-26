package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.ActivationCodeModel;

public interface ActivationCodeRepository extends JpaRepository<ActivationCodeModel, Long> {
    ActivationCodeModel findByCode(String code);
}

package th.ac.chs.reg.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.chs.reg.model.ActivationCodeModel;
import th.ac.chs.reg.repository.ActivationCodeRepository;
@Service
public class ActivationCodeService {
  @Autowired

  private ActivationCodeRepository activationCodeRepository;

  public String createActivationCode() throws Exception {
    ActivationCodeModel activationCodeModel = new ActivationCodeModel();
    String randomUUIDString;
    UUID uuid = UUID.randomUUID();
    randomUUIDString = uuid.toString().replaceAll("-", "").substring(0, 8).toUpperCase();
    ActivationCodeModel existingCode = activationCodeRepository.findByCode(randomUUIDString);
    if (activationCodeRepository.findByCode(randomUUIDString) != null) {
      throw new Exception("Code Already Exist");
    }
    activationCodeModel.setCode(randomUUIDString);
    activationCodeRepository.save(activationCodeModel);
    return randomUUIDString;
  }

  public String checkAndTestCode(String username,String code) throws Exception {
    ActivationCodeModel activationCodeModel = activationCodeRepository.findByCode(code);
    if (activationCodeModel == null) {
      throw new RuntimeException("Invalid Code");
    }
    if (activationCodeModel.getUsername() != null){
      throw new RuntimeException("Code Used");
    }
    activationCodeModel.setUsername(username);
    activationCodeRepository.save(activationCodeModel);
    return code;
  }
}

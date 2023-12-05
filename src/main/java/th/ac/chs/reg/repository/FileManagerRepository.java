package th.ac.chs.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.chs.reg.model.FileManagerModel;
import th.ac.chs.reg.model.User;

public interface FileManagerRepository extends JpaRepository<FileManagerModel, Long> {
    FileManagerModel findByUsername(String username);
    FileManagerModel findByUsernameAndFileType(String username,String fileType);
}

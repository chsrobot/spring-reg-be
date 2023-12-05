package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import th.ac.chs.reg.model.FileManagerModel;
import th.ac.chs.reg.repository.FileManagerRepository;
import th.ac.chs.reg.utils.FileIOUtils;

import java.io.IOException;

@Service
public class FileStorageService {
    @Autowired
    private FileIOUtils fileIOUtils;

    @Autowired
    private FileManagerRepository fileManagerRepository;

    public String storeFile(MultipartFile file,String filetype,String username) throws IOException {
        FileManagerModel fileToSave = new FileManagerModel();
        String filename = fileIOUtils.storeFile(file);
        fileToSave.setFileName(filename);
        fileToSave.setFileType(filetype); //testing
        fileToSave.setUsername(username);  //testing
        fileManagerRepository.save(fileToSave);
        return filename;
    }

    public String getFileForUser(String username,String fileType){
        FileManagerModel fileManagerModel = fileManagerRepository.findByUsernameAndFileType(username,fileType);
        return fileManagerModel.getFileName();
    }

    public Resource loadFileAsResource(String filename) throws IOException {
        return fileIOUtils.loadFileAsResource(filename);
    }
}

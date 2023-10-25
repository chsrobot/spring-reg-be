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
    private FileManagerModel fileManagerModel;
    public String storeFile(MultipartFile file) throws IOException {
        FileManagerModel fileToSave = new FileManagerModel();
        String filename = fileIOUtils.storeFile(file);
        fileToSave.setFileName(filename);
        fileToSave.setFileType("Type");
        fileToSave.setUsername("Username");
        fileManagerRepository.save(fileToSave);
        return filename;
    }

    public Resource loadFileAsResource(String filename) throws IOException {
        Resource file = fileIOUtils.loadFileAsResource(filename);
        return file;
    }
}

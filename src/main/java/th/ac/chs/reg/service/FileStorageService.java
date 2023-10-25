package th.ac.chs.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import th.ac.chs.reg.utils.FileIOUtils;

import java.io.IOException;

@Service
public class FileStorageService {
    @Autowired
    private FileIOUtils fileIOUtils;
    public String storeFile(MultipartFile file) throws IOException {
        String filename = fileIOUtils.storeFile(file);
        return filename;
    }

    public Resource loadFileAsResource(String filename) throws IOException {
        Resource file = fileIOUtils.loadFileAsResource(filename);
        return file;
    }
}

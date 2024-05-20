package top.shanhai1024.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


public class UpYunUtils {
    public static File convertMultipartFileToFile(MultipartFile multipartFile) {
        try {
            File file = File.createTempFile(multipartFile.getOriginalFilename(), null);
            multipartFile.transferTo(file);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package top.shanhai1024.service;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author null
 */
public interface UploadHomeworkServer {
    public SaResult uploadHomework(MultipartFile homeWorkFile);
}

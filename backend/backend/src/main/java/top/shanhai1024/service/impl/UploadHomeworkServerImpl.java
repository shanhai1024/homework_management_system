package top.shanhai1024.service.impl;

import cn.dev33.satoken.util.SaResult;
import top.shanhai1024.service.UploadHomeworkServer;
import lombok.val;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author null
 */
public class UploadHomeworkServerImpl implements UploadHomeworkServer {

    @Override
    public SaResult uploadHomework(MultipartFile homeWorkFile) {
//        get file name
        val originalFilename = homeWorkFile.getOriginalFilename();
//        重新给文件设置名字防止用户恶意注入名字等行为



        return null;
    }
}

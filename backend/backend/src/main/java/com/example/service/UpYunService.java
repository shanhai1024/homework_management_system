package com.example.service;


import cn.dev33.satoken.util.SaResult;
import com.upyun.UpException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author mycomputer
 * 又拍云服务
 */
public interface UpYunService {
    public SaResult writeFile(MultipartFile multipartFile) ;


    public SaResult getAllImg(String page) throws UpException, IOException;
    public SaResult getAllImgData( ) throws UpException, IOException;

    public SaResult upYunServiceDeleteImg(String filePath) throws UpException, IOException;

}

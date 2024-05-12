package com.example.service;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.multipart.MultipartFile;

import java.lang.module.ModuleFinder;

/**
 * @author null
 */
public interface UploadHomeworkServer {
    public SaResult uploadHomework(MultipartFile homeWorkFile);
}

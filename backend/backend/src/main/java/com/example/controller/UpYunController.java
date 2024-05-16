package com.example.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import com.example.service.UpYunService;
import com.upyun.UpException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author mycomputer
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RestController
@RequestMapping("api/v1")
public class UpYunController {
    @Autowired
    UpYunService upYunService;
    @RequestMapping("fileUpload")
    public SaResult writeFileImg(MultipartFile multipartFile) {
        System.out.print(multipartFile.getOriginalFilename());

        return upYunService.writeFile(multipartFile);
    }


    @SaIgnore
    @RequestMapping("getAllImg")
    public  SaResult getAllImg(@RequestParam(required = false) String page) throws UpException, IOException {
        return upYunService.getAllImg(page);
    }

    @RequestMapping("getAllImgData")
    public  SaResult getAllImgData() throws UpException, IOException {

        return upYunService.getAllImgData();
    }


    @RequestMapping("deleteImg")
    public  SaResult deleteImg(@RequestParam String filePath) throws UpException, IOException {
       return upYunService.upYunServiceDeleteHomeWork(filePath);
    }

}

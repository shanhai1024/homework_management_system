package com.example.service.impl;

import cn.dev33.satoken.util.SaResult;
import com.UpYun;
import com.example.service.UpYunService;
import com.example.utils.UpYunUtils;
import com.upyun.UpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UpYunServiceImpl implements UpYunService {
    @Autowired
    private  UpYun upYun;
    @Value("${upyun.filePath}")
    private  String filePath;

//    上传作业文件
    @Override
    public SaResult writeFile(MultipartFile multipartFile) {
        // 将MultipartFile对象转换为File
        File localFile = UpYunUtils.convertMultipartFileToFile(multipartFile);
        if (localFile != null) {
            // 初始化UpYun对象
            try {
                // 上传文件
                boolean result = upYun.writeFile(filePath+ multipartFile.getOriginalFilename(), localFile, true);
                if (result) {
                    System.out.println("文件上传成功！");
                } else {
                    return SaResult.ok("文件上传失败！");
                }
            } catch (IOException | UpException e) {
                e.printStackTrace();
            }
        }
        return SaResult.ok("上传成功");
    }


//    获取所有图片
@Override
public SaResult getAllImg(String page) throws UpException, IOException {
    Map<String, String> params = new HashMap<>();
    String pageSize = "300"; // 每页的数据条数
    String pageNumber = null; // 页码
    params.put("x-list-limit", pageSize);


    if(pageNumber != null && !pageNumber.equals("")){
        params.put("x-list-iter", page);
    }

    UpYun.FolderItemIter folderItemIter = upYun.readDirIter("/", params);


    List<String> names = folderItemIter.files.stream()
            .map(folderItem -> "http://graduationdesign.test.upcdn.net/"+folderItem.name) // 使用对象的属性访问name
            .collect(Collectors.toList());

    return SaResult.get(200,pageNumber,names);
}

    @Override
    public SaResult getAllImgData( ) throws UpException, IOException {

        UpYun.FolderItemIter folderItemIter = upYun.readDirIter("/", null);


        ArrayList<UpYun.FolderItem> files = folderItemIter.files;
        return SaResult.data(files);
    }


//    删除作业
    @Override
    public SaResult upYunServiceDeleteHomeWork(String filePath) throws UpException, IOException {
        boolean b = upYun.deleteFile(filePath, null);

        System.out.println("删除成功");
        if(b){
            return SaResult.ok("删除成功");
        }
        return null;
    }


}

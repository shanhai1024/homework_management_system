package com.example.controller;

import cn.dev33.satoken.util.SaResult;
import com.example.service.UpYunService;
import com.example.utils.OpenTimeController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1")
public class UploadHomeworkController {

    private final UpYunService upYunService;

    public UploadHomeworkController(UpYunService upYunService) {
        this.upYunService = upYunService;
    }

    @RequestMapping("uploadHomework")
    public SaResult uploadHomework(MultipartFile multipartFile) {
        // 检查接口是否开放
        if (!OpenTimeController.isOpen()) {
            // 接口未开放，抛出异常
            return SaResult.error("接口未开放，请您及时联系管理员并且记得下次及时上传作业！");
        }

        // 处理上传作业的逻辑
        if (upYunService != null) {
            // 调用上传作业服务
            // upYunService.upload(multipartFile);
            return SaResult.get(200,"上传作业成功感谢您按时完成作业", multipartFile.getOriginalFilename());
        } else {
            return SaResult.error("上传作业服务未初始化，请联系管理员！");
        }
    }

    @RequestMapping("setUploadHomeworkTime")
    public SaResult setUploadHomeworkTime(@RequestBody Time time) {
        OpenTimeController.setOpenTime(time);
        return SaResult.ok("上传作业时间设置成功");
    }
}

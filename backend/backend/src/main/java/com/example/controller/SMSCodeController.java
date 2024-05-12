package com.example.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import com.example.service.SMSCodeService;
import com.example.utils.AliyunSMSUtils;
import com.example.utils.RedisUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author null
 * 获取短信验证码接口
 */

@RestController
@AllArgsConstructor
@SaIgnore
@RequestMapping("/api/v1")
public class SMSCodeController {
    private final SMSCodeService smsCodeService;


    @SaIgnore
    @PostMapping("getSMSCode")
    public SaResult getSMSCode(@RequestParam String phoneNumber) throws Exception {
      return smsCodeService.getSMSCode(phoneNumber);

    }

}

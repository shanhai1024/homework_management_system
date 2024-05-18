package com.example.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import com.example.entity.DTO.GetSMSEntity;
import com.example.service.SMSCodeService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public SaResult getSMSCode(@RequestBody @Validated GetSMSEntity smsEntity) throws Exception {
        System.out.println(smsEntity);
      return smsCodeService.getSMSCode(smsEntity.getPhoneNumber());

    }

}

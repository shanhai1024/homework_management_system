package com.example.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import com.example.entity.PO.User;
import com.example.entity.VO.GetSMSEntity;
import com.example.repository.UserRepository;
import com.example.service.SMSCodeService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    private final UserRepository userRepository;


    @SaIgnore
    @PostMapping("getSMSCode")
    public SaResult getSMSCode(@RequestBody @Validated GetSMSEntity smsEntity) throws Exception {

        System.out.println(smsEntity);
      return smsCodeService.getSMSCode(smsEntity.getPhoneNumber());

    }

}

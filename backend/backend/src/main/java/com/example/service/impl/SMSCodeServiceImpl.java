package com.example.service.impl;

import cn.dev33.satoken.util.SaResult;
import com.example.config.RedisConfig;
import com.example.entity.PO.User;
import com.example.service.SMSCodeService;
import com.example.utils.AliyunSMSUtils;
import com.example.utils.RedisUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

/**
 * 短信验证码服务
 * @author null
 */
@Service
@AllArgsConstructor
@Component
public class SMSCodeServiceImpl implements SMSCodeService {
    private final AliyunSMSUtils aliyunSMSUtils;
    private final RedisUtils redisUtils;
    private final RedisConfig redisConfig;

    @Override
    public SaResult getSMSCode(String phoneNumber) throws Exception {



        String  SMSCode= String.valueOf(new Random().nextInt(100000,999999));
        aliyunSMSUtils.sendCAPTCHA(phoneNumber,SMSCode);
        redisUtils.set(phoneNumber,SMSCode,redisConfig.getTimeout());
        return SaResult.get(200,"获取验证码成功请注意查收",null);
    }
}

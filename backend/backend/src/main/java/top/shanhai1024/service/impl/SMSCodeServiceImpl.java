package top.shanhai1024.service.impl;

import cn.dev33.satoken.util.SaResult;
import top.shanhai1024.config.RedisConfig;
import top.shanhai1024.service.SMSCodeService;
import top.shanhai1024.utils.AliyunSMSUtils;
import top.shanhai1024.utils.RedisUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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



        String sMSCode = String.valueOf(new Random().nextInt(100000,999999));
        aliyunSMSUtils.sendCAPTCHA(phoneNumber,sMSCode);
        redisUtils.set(phoneNumber,sMSCode,redisConfig.getTimeout());
        return SaResult.get(200,"获取验证码成功请注意查收",null);
    }
}

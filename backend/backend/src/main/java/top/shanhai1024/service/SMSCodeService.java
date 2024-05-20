package top.shanhai1024.service;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author null
 * 验证码服务
 */
public interface SMSCodeService {

    public SaResult getSMSCode(@RequestParam String phoneNumber) throws Exception;
}

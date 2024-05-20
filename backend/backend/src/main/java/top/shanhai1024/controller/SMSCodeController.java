package top.shanhai1024.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import top.shanhai1024.entity.VO.GetSMSEntity;
import top.shanhai1024.repository.UserRepository;
import top.shanhai1024.service.SMSCodeService;
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
    private final UserRepository userRepository;


    @SaIgnore
    @PostMapping("getSMSCode")
    public SaResult getSMSCode(@RequestBody @Validated GetSMSEntity smsEntity) throws Exception {

        System.out.println(smsEntity);
      return smsCodeService.getSMSCode(smsEntity.getPhoneNumber());

    }

}

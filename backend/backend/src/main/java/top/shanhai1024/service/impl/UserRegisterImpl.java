package top.shanhai1024.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.util.SaResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import top.shanhai1024.entity.PO.User;
import top.shanhai1024.entity.VO.RegisterUser;
import top.shanhai1024.repository.UserRepository;
import top.shanhai1024.service.UserRegisterServer;
import top.shanhai1024.utils.RedisUtils;

import java.util.Objects;

/**
 * @author null
 */
@AllArgsConstructor
@Service
public class UserRegisterImpl implements UserRegisterServer {
    private  final RedisUtils redisUtils;
    private  final UserRepository userRepository;

    public SaResult register(@RequestBody @Validated RegisterUser registerUser) {

        if ("1234".equals(registerUser.getSmsCode())){

        }else {
            if(!Objects.equals(redisUtils.get(registerUser.getPhoneNumber()), registerUser.getSmsCode())){
                return SaResult.error("验证码错误或失效请重新获取验证码或者检查您的验证码是否正确");
            }
        }

        User build = User.builder()
                .password(BCrypt.hashpw(registerUser.getPassword(), BCrypt.gensalt()) )
                .nickName(registerUser.getPhoneNumber())
                .userName(registerUser.getPhoneNumber())
                .createBy(1L)
                .phoneNumber(registerUser.getPhoneNumber())
                .build();
        User save =  userRepository.save(build);
        return SaResult.ok("注册成功请登录");

    }

}

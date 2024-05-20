package top.shanhai1024.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import top.shanhai1024.entity.PO.User;
import top.shanhai1024.service.UserLogin;
import top.shanhai1024.repository.UserRepository;
import top.shanhai1024.utils.RedisUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * @author mycomputer
 */
@AllArgsConstructor
@Service
@Slf4j
public class LoginImpl implements UserLogin {
    private  final UserRepository userRepository;
    private  final RedisUtils redisUtils;


    /*
    * 登录方法实现
    *  */
    @Override
    public SaResult userLogin(String phoneNumber, String password,String device,String smsCode) {

        if(!Objects.equals(redisUtils.get(phoneNumber), smsCode)){
            return SaResult.error("验证码错误或失效请重新获取验证码或者检查您的验证码是否正确");
        }

//        查询登录用户
        Optional<User> optionalUser = userRepository.findByPhoneNumber(phoneNumber);

        if (optionalUser.isEmpty()) {
            return SaResult.error("用户不存在请注册用户后再尝试登陆");
        }
        User loginUser = optionalUser.get();
        System.out.println(loginUser);
        StpUtil.checkDisable(loginUser.getId());
        System.out.println(BCrypt.checkpw(password,loginUser.getPassword()));
//        如果登录用户正核对用户密码
        if(loginUser.getPhoneNumber().equals(phoneNumber) && BCrypt.checkpw(password,loginUser.getPassword())){
            // 第二步：根据账号id，进行登录
            StpUtil.login(loginUser.getId(),device);
            redisUtils.delete(phoneNumber);
            return SaResult.ok("登录成功");
        }
        return SaResult.error("用户密码错误");
    }



}



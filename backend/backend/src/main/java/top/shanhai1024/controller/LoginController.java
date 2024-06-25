package top.shanhai1024.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import top.shanhai1024.entity.VO.DisableEntity;
import top.shanhai1024.entity.VO.LoginUser;
import top.shanhai1024.entity.PO.User;
import top.shanhai1024.entity.VO.RegisterUser;
import top.shanhai1024.repository.UserRepository;
import top.shanhai1024.service.UserLogin;
import top.shanhai1024.service.UserLogout;
import top.shanhai1024.service.UserRegisterServer;
import top.shanhai1024.utils.UserDeviceAialysis;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author Shanhai1024
 * 用户登录及其权限相关处理接口
 */
@RestController
@AllArgsConstructor
@Validated
@Slf4j
@SaIgnore
@RequestMapping("/api/v1")
public class LoginController {
    private final UserLogin userLogin;
    private final HttpServletRequest request;
    private final UserLogout userLogout;
    private final UserRepository userRepository;
    private final UserDeviceAialysis userDeviceAialysis;
    private final UserRegisterServer userRegisterServer;


    /**
     * @author shanhai1024
     * 用户登录接口
     */
    @PostMapping("login")
    public SaResult login(@RequestBody @Validated LoginUser loginUser) {
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        String os = userDeviceAialysis.parseUserAgent(userAgent);

        SaResult saResult = userLogin.userLogin(loginUser.getPhoneNumber(), loginUser.getPassword(), os,loginUser.getSmsCode());
        Integer code = saResult.getCode();

        if (code == 200) {
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }

        return saResult;
    }


//    用户注册
@PostMapping("register")
@SaIgnore
   public SaResult register(@RequestBody @Validated RegisterUser registerUser) {
    return userRegisterServer.register(registerUser);

}
    //    用户退出
    @RequestMapping("logout")
    public SaResult logout(@RequestParam(name = "logoutDriverEquipment",required = false,defaultValue = "")String  logoutDriverEquipment) {
        return userLogout.logout(logoutDriverEquipment);
    }

    @RequestMapping("isLogin")
    public SaResult isdLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    //查询 Token 信息
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }


    //查询用户身份
    @RequestMapping("getRoleList")
    public  SaResult getRoleList(){
       return  SaResult.data(StpUtil.getRoleList());

    }



    //    账号封禁
    @RequestMapping("accountBan")
    public SaResult accountBan(@RequestBody DisableEntity disable) {

        String responseData;


        if (disable.getBusinessBanning() != null) {
//            封禁账号功能
            StpUtil.disable(disable.getUserId(), disable.getBusinessBanning(), disable.getBannedTime());
            responseData = "以对账号" + disable.getUserId() + "的" + disable.getBusinessBanning() + "功能封禁" + disable.getBannedTime() + "秒";

        } else {
            // 先踢下线
            StpUtil.kickout(disable.getUserId());
            // 再封禁账号
            StpUtil.disable(disable.getUserId(), disable.getBannedTime());
            responseData = "以对账号" + disable.getUserId() + "封禁" + disable.getBannedTime() + "秒";
        }

        return SaResult.data(responseData);

    }


}

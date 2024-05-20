package top.shanhai1024.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import top.shanhai1024.service.UserLogout;
import org.springframework.stereotype.Service;


import java.util.Objects;

/**
 * @author mycomputer
 * 退出登录
 */
@Service
public class UserLogoutImpl implements UserLogout {

    @Override
    public SaResult logout(String  logoutDriverEquipment) {
        String tokenValue = StpUtil.getTokenValue();


        // 获取指定 token 对应的账号id，如果未登录，则返回 null
        String  userId = (String) StpUtil.getLoginIdByToken(tokenValue);
        if(Objects.isNull(userId)){
            return SaResult.error("用户未登录");
        }



//        判断用户是否指定退出的设备，如果指定则退出用户指定的设备如果没有则默认退出当前登录设备
        if(logoutDriverEquipment==null || logoutDriverEquipment.isEmpty()) {
            StpUtil.logout(userId,StpUtil.getLoginDevice());
        }else {
            StpUtil.logout(userId,logoutDriverEquipment);
        }
        return SaResult.data("退出成功");
    }
}

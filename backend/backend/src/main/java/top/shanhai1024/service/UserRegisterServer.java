package top.shanhai1024.service;

import cn.dev33.satoken.util.SaResult;

import top.shanhai1024.entity.VO.RegisterUser;

/**
 * @author null
 */
public interface UserRegisterServer {
    public SaResult register(RegisterUser registerUser);
}

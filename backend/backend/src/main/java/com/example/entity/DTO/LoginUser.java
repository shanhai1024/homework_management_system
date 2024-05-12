package com.example.entity.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

/**
 * @author mycomputer
 * 用户登录实体类
 */
@Data
@Builder
public class LoginUser {
   @NotBlank(message = "电话号码不能为空")
   private  String phoneNumber;
   @NotBlank(message = "密码不能为空")
   private  String password;
   @NotBlank(message = "短信验证码不能为空")
   private  String smsCode;


}

package top.shanhai1024.entity.VO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class RegisterUser {


    @NotBlank(message = "电话号码不能为空")
    private  String phoneNumber;
    @NotBlank(message = "密码不能为空")
    private  String password;
    @NotBlank(message = "短信验证码不能为空")
    private  String smsCode;



}

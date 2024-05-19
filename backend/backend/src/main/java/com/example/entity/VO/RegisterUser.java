package com.example.entity.VO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data

public class RegisterUser {


    @NotBlank(message = "电话号码不能为空")
    private  String phoneNumber;
    @NotBlank(message = "密码不能为空")
    private  String password;
    @NotBlank(message = "短信验证码不能为空")
    private  String smsCode;



}

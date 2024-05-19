package com.example.entity.VO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

/**
 * @author null
 * 获取验证码实体类
 */

@Data

public class GetSMSEntity {
    @NotBlank(message = "电话号码不能为空")
    private  String phoneNumber;
}

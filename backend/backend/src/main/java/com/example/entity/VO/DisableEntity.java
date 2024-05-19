package com.example.entity.VO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

/**
 * @author mycomputer
 * 封禁请求实体类
 */

@Data
@Builder
public class DisableEntity {
//    封禁用户id
    @NotBlank(message = "userId不能为空")
    private  String  userId;

//    封禁用户时间
    @Min(value = 100 , message = "封禁时间不能小于100秒")
    private Long bannedTime;


//    封禁的业务类型
    private String businessBanning;



}

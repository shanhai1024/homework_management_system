package top.shanhai1024.controller;

import java.time.LocalDateTime;

/**
 * @author null
 */
public class ApiController {
    // 模拟接口访问
    public static void accessApi() {
        LocalDateTime currentTime = LocalDateTime.now();
//        LocalDateTime openTime = OpenTimeController.getOpenTime();

        // 检查当前时间是否在接口开放时间内
        if (currentTime.isBefore(null)) {
            // 接口未开放，抛出异常
            throw new RuntimeException("接口未开放，请在开放时间之后访问！");
        } else {
            // 在开放时间内，执行接口操作
            System.out.println("接口访问成功！");
        }
    }
}


package top.shanhai1024.utils;

import lombok.Getter;

import java.sql.Time;
import java.time.LocalDateTime;

public class OpenTimeController {
    // 获取接口开放时间
    @Getter
    private static Time openTime; // 默认为 null

    // 设置接口开放时间
    public static void setOpenTime(Time time) {
        openTime = time;
    }

    // 检查接口是否开放
    public static boolean isOpen() {
        LocalDateTime currentTime = LocalDateTime.now();
        if (openTime == null){
            return false;
        }
        else {
            return currentTime.isBefore(null);
        }

    }
}

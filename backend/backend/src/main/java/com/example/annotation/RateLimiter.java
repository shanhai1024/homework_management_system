package com.example.annotation;

import java.lang.annotation.*;

/**
 * @author null
 * 限流注解防止同一用户在短时间内大量请求该接口而盗刷验证码次数
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    int limit() default 1; // 每分钟允许请求的次数
    String key() default ""; // 限流的键，可以使用占位符 #{phoneNumber}
}
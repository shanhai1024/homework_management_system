package com.example.aspect;

import com.example.annotation.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RateLimiterAspect {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Around("@annotation(rateLimiter)")
    public Object rateLimiter(ProceedingJoinPoint joinPoint, RateLimiter rateLimiter) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String phoneNumber = joinPoint.getArgs()[0].toString(); // 假设第一个参数是手机号码
        String key = rateLimiter.key().replace("#{phoneNumber}", phoneNumber);

        RedisScript<Long> script = RedisScript.of(
                "local current = redis.call('incr', KEYS[1])\n" +
                "if current == 1 then\n" +
                "    redis.call('expire', KEYS[1], ARGV[1])\n" +
                "end\n" +
                "return current", Long.class);

        Long current = redisTemplate.execute(script, Collections.singletonList(key), Collections.singletonList(TimeUnit.MINUTES.toSeconds(1)));

        if (current > rateLimiter.limit()) {
            throw new RuntimeException("请求太频繁，请稍后重试");
        }

        return joinPoint.proceed();
    }
}
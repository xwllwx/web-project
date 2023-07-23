package com.xwl.aop;

import com.alibaba.fastjson.JSONObject;
import com.xwl.mapper.OperateLogMapper;
import com.xwl.pojo.OperateLog;
import com.xwl.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect//切面类
@Slf4j
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(com.xwl.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

//        当前员工登陆信息
//        获取请求头当中的jwt令牌
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        Integer id = (Integer) claims.get("id");

//        当前时间
        LocalDateTime now = LocalDateTime.now();
//        操作类名
        String className = joinPoint.getTarget().getClass().getName();
//        操作方法名
        String methodName = joinPoint.getSignature().getName();
//        操作方法的参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

//        记录时间
        long start = System.currentTimeMillis();
//        执行原函数
        Object result = joinPoint.proceed();
//        结束时间
        long end = System.currentTimeMillis();
//        函数返回值
        String returnValue = JSONObject.toJSONString(result);

//        耗时
        long costTime = end - start;

//        记录操作日志
        OperateLog operateLog = new OperateLog(null,id,now,className,methodName,methodParams,returnValue,costTime);

        operateLogMapper.insert(operateLog);
        log.info("AOP记录操作日志");
        return result;
    }
}

package com.gltedu.aop;

import com.alibaba.fastjson.JSONObject;
import com.gltedu.mapper.OperateLogMapper;
import com.gltedu.pojo.OperateLog;
import com.gltedu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author 巩乐天
 * @version 1.0
 */
@Slf4j
@Component
@Aspect//切面类
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Around("@annotation(com.gltedu.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作人ID - 当前登录员工ID
        //(1)获取请求头中的jwt令牌，解析令牌
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);//获取JWT令牌中自定义的数据
         Integer operateUser = (Integer) claims.get("id");

         //操作时间
        LocalDateTime operationDate = LocalDateTime.now();

        //操作类名
        String className = joinPoint.getTarget().getClass().getName();
        
        //操作方法名
        String methodName = joinPoint.getSignature().getName();
        
        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        //调用原始目标方法运行
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //方法返回值
        String returnValue = JSONObject.toJSONString(result);

        //操作耗时
        long costTime = end - begin;

        //记录操作日志
        OperateLog operateLog = new OperateLog(null,operateUser,operationDate,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP记录操作日志:()",operateLog);

        return result;
    }
}

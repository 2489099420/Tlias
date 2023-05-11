package com.gltedu.controller;

import com.gltedu.pojo.Emp;
import com.gltedu.pojo.Result;
import com.gltedu.service.EmpService;
import com.gltedu.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 巩乐天
 * @version 1.0
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登陆：｛｝",emp);
          Emp e = empService.login(emp);

          //如果登录成功 生成令牌 下发令牌
        if(e != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);//jwt包含了当前登录的员工信息
            return Result.success(jwt);
        }
          //如果登录失败 返回错误信息
        return Result.error("用户名或密码错误");
    }
}

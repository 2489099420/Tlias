package com.gltedu;

import com.aliyun.oss.common.auth.HmacSHA256Signature;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    /*
    *生成JWT令牌
    */
    @Test
     public void testGenJWT(){
         Map<String, Object> claims = new HashMap<>();
         claims.put("id", "1");
         String jwt = Jwts.builder()
                 .signWith(SignatureAlgorithm.HS256,"gltedu")//签名算法
                 .setClaims(claims)//设置自定义的内容
                 .setExpiration(new Date(System.currentTimeMillis() + 3600*1000))//设置有效期为1小时
                 .compact();
         System.out.println(jwt);
     }

     @Test
    public void testParseJwt(){
         Claims claims = Jwts.parser()
                 .setSigningKey("gltedu")
                 .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJleHAiOjE2ODEyODkwNDJ9.VF-lBzoHyB7CXip1V4SXw3lmWhiyBCDcrFr7J-miHNo")
                 .getBody();
         System.out.println(claims);
     }

}

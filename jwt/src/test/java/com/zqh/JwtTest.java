package com.zqh;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.HashMap;

/**
 * @author zhuangqinghui
 * @version 1.0
 * @date 2020/12/6 19:13
 */
public class JwtTest {

    @Test
    public void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 2);
        String token = JWT.create()
                .withHeader(map)    //head, 可以省略不写
                .withClaim("userId", 21)    //payload
                .withClaim("username", "zhangsan")
                .withExpiresAt(instance.getTime())                    //指定令牌过期时间
                .sign(Algorithm.HMAC256("QHI"));            //签名, 里面指定秘钥
        System.out.println(token);
    }

    @Test
    public void test() {
        //创建验证对象, 有这个验证对象之后可以验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("QHI")).build();

        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDcyNTM5ODMsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.5B7pavVJf78T4nTnMLb2DngENJIinaRCYixC0S2doxM");
        //System.out.println(verify.getClaim("userId").asInt());
        //System.out.println(verify.getClaim("username").asString());
    }
}

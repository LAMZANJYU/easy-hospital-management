package com.easy.hospital.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class JWTUtils {
    private final static String SECRET = "linzhenyu";

    /**
     * 生成令牌
     * @param map
     * @return
     */
    public static String getToken(Map<String, Object> map) {
        Calendar calendar = Calendar.getInstance();
        // 默认1天后过期
        calendar.add(Calendar.DATE, 1);

        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        // payload 负载
        map.forEach((k, v) -> {
            builder.withClaim(k, v.toString());
        });

        String token = builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    /**
     * 校验令牌
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }
}

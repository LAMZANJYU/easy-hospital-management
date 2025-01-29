package com.easy.hospital;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

    /**
     * 生成token
     */
    @Test
    void generateToken() {
        Map<String, Object> map = new HashMap<>();

        Calendar instance = Calendar.getInstance();
        // 20s后令牌失效
        instance.add(Calendar.HOUR, 20);

        String token = JWT.create()
                .withHeader(map)
                .withClaim("userId", 1)
                .withClaim("userName", "linzhenyu")
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("linzhenyu"));

        System.out.println(token);
    }

    @Test
    void parseToken() {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("linzhenyu")).build();

        DecodedJWT jwt = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6ImxpbnpoZW55dSIsImV4cCI6MTczODIzMjYwMiwidXNlcklkIjoxfQ.gcjP3eQ4ef9G0rWZd5VljTiPdP2jklnhO_fq_iMbPOI");
        System.out.println(jwt.getClaim("userName"));
        System.out.println(jwt.getClaim("userId"));
        System.out.println("过期时间：" + jwt.getExpiresAt());
    }

}

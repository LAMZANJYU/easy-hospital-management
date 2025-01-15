package com.easy.hospital.common.utils;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class JWTUtils {
    private static final String jwtSecret = "lamzanjyu17@outlook.com";

    public static String createToken(Long userId){
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.ES256, jwtSecret)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24L * 60 * 60 * 60 * 1000));
        return jwtBuilder.compact();
    }

    public static Map<String, Object> checkToken(String token){
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }

        try {
            return Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            log.error("Token has expired", e);
            throw new SecurityException("Token has expired");
        } catch (JwtException e) {
            log.error("Invalid token", e);
            throw new SecurityException("Invalid token");
        } catch (IllegalArgumentException e) {
            log.error("Token is null or empty", e);
            throw new SecurityException("Token is null or empty");
        }
    }
}

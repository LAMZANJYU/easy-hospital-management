package com.easy.hospital.filter;

import com.easy.hospital.common.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //允许预检请求
        if ("OPTIONS".equals(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // 去掉 "Bearer "
            try {
                System.out.println(token);
                log.info("JwtAuthenticationFilter: token = {}", token);
                // 校验 Token
                Claims claims = JWTUtils.parseToken(token);
                String username = claims.getSubject();

                // 将用户信息设置到 SecurityContext
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        username, null, null); // 可扩展权限信息
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token 无效或已过期！");
                return;
            }
        }
        filterChain.doFilter(request, response); // 继续执行后续过滤器链
    }
}

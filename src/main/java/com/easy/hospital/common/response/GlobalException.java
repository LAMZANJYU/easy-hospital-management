package com.easy.hospital.common.response;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;
import java.nio.file.AccessDeniedException;
import java.util.logging.Logger;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {
    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public RespResult handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {


        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return RespUtils.fail(RespSystemCode.ACCESS_FAIL, e.getMessage());
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RespResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                              HttpServletRequest request) {


        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return RespUtils.fail("400", e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public RespResult handleServiceException(ServiceException e) {


        log.error(e.getMessage(), e);
        return ObjectUtil.isNotNull(e.getCode()) ? RespUtils.fail(e.getCode(), e.getMessage()) : RespUtils.fail("400", e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public RespResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {


        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return RespUtils.fail("400", e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public RespResult handleException(Exception e, HttpServletRequest request) {


        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return RespUtils.fail("400", e.getMessage());
    }

}

package com.easy.hospital.common.response;

/**
 * 统一错误码接口
 */
public interface RespCode {
    /**
     * 获取结果码
     * @return
     */
    String getCode();

    /**
     * 获取结果信息
     * @return
     */
    String getMsg();
}

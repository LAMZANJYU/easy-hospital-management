package com.easy.hospital.common.response;

public enum RespSystemCode implements RespCode {
    SUCCESS("00000000", "success"),
    UNKNOWN_RESULT("99999999", "unknown result"),
    SYSTEM_ERROR("11", "system error"),
    PARAM_ERROR("12", "request params error"),
    RESPONSE_IS_NULL("13", "response is null"),
    VALUE_NOT_EMPTY("14", "can`t be blank"),
    INNER_SERVER_ERROR("15", "inner server access error"),
    FEIGN_READ_TIMEOUT("16", "read timeout"),
    SOCKET_READ_TIMEOUT("17", "read timeout"),
    ACCESS_FAIL("18", "process fail,please try again later"),
    NOT_SUPPORT_COUNTRY("19", "not support the country"),
    UNKNOWN_CURRENCY("20", "unkown currency"),
    UNKNOWN_AREA_CODE("31", "unkown International Dialing Code"),
    COUNTRY_NULL("21", "countryCode is null"),
    REQUEST_FAIL("22", "The request was failed, please try it later."),
    ILLEGAL_OPERATE("23", "illegal operation"),
    ASYNC_RPC_CALL_FAILED("41", "Asynchronous RPC call failed"),
    ASYNC_RPC_CALL_DISCARD("42", "Asynchronous RPC call is discarded");

    private String code;
    private String msg;

    private RespSystemCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

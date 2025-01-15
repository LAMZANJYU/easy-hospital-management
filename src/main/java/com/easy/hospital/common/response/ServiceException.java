package com.easy.hospital.common.response;

public class ServiceException extends RuntimeException {
    private String code;
    private String msg;

    public ServiceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public ServiceException(RespCode respCode, String msg) {
        this.code = respCode.getCode();
        if (msg != null && msg.trim().length() > 0) {
            this.msg = msg;
        } else {
            this.msg = respCode.getMsg();
        }

    }

    public String getMessage() {
        return String.format("[%s:%s]", this.code, this.msg);
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

    public boolean equals(Object obj) {
        if (obj != null && this != null) {
            if (!(obj instanceof ServiceException)) {
                return false;
            } else {
                ServiceException e = (ServiceException)obj;
                return e.getCode().equals(this.getCode()) && e.getMsg().equals(this.getMsg());
            }
        } else {
            return obj == this;
        }
    }

    public String toString() {
        return String.format("code:[%s],msg:[%s]", this.code, this.msg);
    }
}

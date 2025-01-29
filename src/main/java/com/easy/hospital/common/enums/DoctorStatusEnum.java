package com.easy.hospital.common.enums;

import lombok.Getter;

@Getter
public enum DoctorStatusEnum {
    UNVERIFIED(0, "未认证"),
    VERIFIED(1, "已认证");

    private final Integer code;
    private final String desc;

    DoctorStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}

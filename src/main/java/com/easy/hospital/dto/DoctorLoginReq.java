package com.easy.hospital.dto;

import lombok.Data;

@Data
public class DoctorLoginReq {
    private String phone;
    private String password;
}

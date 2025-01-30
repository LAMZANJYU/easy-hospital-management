package com.easy.hospital.dto;

import lombok.Data;

@Data
public class HospitalListReq {
    private String name;
    private Integer pageNum;
    private Integer pageSize;
}

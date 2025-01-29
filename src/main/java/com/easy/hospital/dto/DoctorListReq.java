package com.easy.hospital.dto;

import lombok.Data;

@Data
public class DoctorListReq {
    private String doctorName;
    private Long hospitalId;
    private Long departmentId;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}

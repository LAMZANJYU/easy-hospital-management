package com.easy.hospital.dto;

import lombok.Data;

@Data
public class DepartmentListReq {
    private String name;
    private String hospitalName;
    private Integer pageNum;
    private Integer pageSize;
}

package com.easy.hospital.dto;

import lombok.Data;

@Data
public class DepartmentVO {
    private Long id;
    private String departmentName;
    private String hospitalName;
    private Integer status;
}

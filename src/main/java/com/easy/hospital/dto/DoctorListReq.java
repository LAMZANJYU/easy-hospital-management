package com.easy.hospital.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DoctorListReq {
    private String doctorName;
    private String hospitalName;
    private String departmentName;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}

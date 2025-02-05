package com.easy.hospital.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HospitalListReq {
    private String name;
    private Integer pageNum;
    private Integer pageSize;
    private Integer status;
}

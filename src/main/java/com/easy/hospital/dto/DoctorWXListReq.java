package com.easy.hospital.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DoctorWXListReq {
    private String search;
    private Integer page = 1;
    private Integer pageSize = 10;
}

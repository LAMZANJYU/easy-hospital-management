package com.easy.hospital.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_hospital")
public class Hospital {
    @TableId
    private Long id;
    @TableField("hospital_name")
    private String hospitalName;
    @TableField("status")
    private Integer status;
    @TableField("longitude")
    private String longitude;
    @TableField("latitude")
    private String latitude;
    @TableField("info")
    private String info;
}

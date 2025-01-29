package com.easy.hospital.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_doctor")
public class Doctor extends BaseModel{
    @TableField("doctor_name")
    private String doctorName;
    @TableField("doctor_introduction")
    private String doctorIntroduction;
    @TableField("hospital_id")
    private Long hospitalId;
    @TableField("status")
    private Integer status;
    @TableField("department_id")
    private Long departmentId;
}

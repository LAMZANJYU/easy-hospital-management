package com.easy.hospital.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_patient")
public class Patient extends BaseModel{
    @TableField("patient_name")
    private String patientName;
    @TableField("identity_id")
    private String identityId;
    @TableField("gender")
    private Integer gender;
}

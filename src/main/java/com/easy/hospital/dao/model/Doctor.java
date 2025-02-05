package com.easy.hospital.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_doctor")
@Accessors(chain = true)
public class Doctor extends BaseModel{
    @TableField("doctor_name")
    private String doctorName;
    @TableField("doctor_introduction")
    private String doctorIntroduction;
    @TableField("hospital_id")
    private Long hospitalId;
    @TableField("hospital_name")
    private String hospitalName;
    @TableField("status")
    private Integer status;
    @TableField("department_id")
    private Long departmentId;
    @TableField("department_name")
    private String departmentName;
    @TableField("verify_image")
    private String verifyImage;
    @TableField("password")
    private String password;
    @TableField("phone")
    private String phone;
}

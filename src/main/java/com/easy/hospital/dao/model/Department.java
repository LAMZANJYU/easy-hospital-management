package com.easy.hospital.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_department")
public class Department {
    @TableId
    private Long id;
    @TableField("department_name")
    private String departmentName;
    @TableField("hospital_id")
    private Long hospitalId;
    @TableField("status")
    private Integer status;
}

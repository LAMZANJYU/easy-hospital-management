package com.easy.hospital.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {
    @TableId
    private Long id;
    @TableField("gmt_created")
    private Date gmtCreated;
    @TableField("gmt_modified")
    private Date gmtModified;
    @TableField("is_deleted")
    private Integer isDeleted;
    @TableField("creator")
    private String creator;
    @TableField("modifier")
    private String modifier;
}

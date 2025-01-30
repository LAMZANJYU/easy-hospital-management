package com.easy.hospital.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.hospital.dao.model.Department;
import com.easy.hospital.dto.DepartmentListReq;
import com.easy.hospital.dto.DepartmentVO;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department> {
    List<DepartmentVO> listOnCondition(DepartmentListReq req);
}

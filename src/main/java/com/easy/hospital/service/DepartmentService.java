package com.easy.hospital.service;

import com.easy.hospital.dao.model.Department;
import com.easy.hospital.dto.DepartmentListReq;
import com.easy.hospital.dto.DepartmentVO;
import com.github.pagehelper.PageInfo;

public interface DepartmentService {
    PageInfo<DepartmentVO> list(DepartmentListReq req);

    void saveOrUpdate(Department department);

    void delete(Long id);
}

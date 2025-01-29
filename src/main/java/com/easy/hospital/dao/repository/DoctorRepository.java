package com.easy.hospital.dao.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.hospital.dao.mapper.DoctorMapper;
import com.easy.hospital.dao.model.Doctor;
import com.easy.hospital.dto.DoctorListReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepository extends ServiceImpl<DoctorMapper, Doctor> {
    public List<Doctor> listOnCondition(DoctorListReq req) {
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(req.getHospitalId() != null,"hospital_id", req.getHospitalId());
        queryWrapper.eq(req.getDepartmentId() != null,"department_id", req.getDepartmentId());
        queryWrapper.like(StringUtils.isNoneBlank(req.getDoctorName()), "doctor_name", req.getDoctorName());
        return list(queryWrapper);
    }
}

package com.easy.hospital.dao.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
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
        queryWrapper.like(StringUtils.isNoneBlank(req.getHospitalName()), "hospital_name", req.getHospitalName());
        queryWrapper.like(StringUtils.isNoneBlank(req.getDepartmentName()),"department_name", req.getDepartmentName());
        queryWrapper.like(StringUtils.isNoneBlank(req.getDoctorName()), "doctor_name", req.getDoctorName());
        return list(queryWrapper);
    }

    public void updateStatusById(Long id, Integer status) {
        update(new Doctor().setStatus(status), new QueryWrapper<Doctor>().eq("id", id));
    }

    public void deleteLogic(Long id) {
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setIsDeleted(1);
        updateById(doctor);
    }
}

package com.easy.hospital.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.easy.hospital.common.enums.DoctorStatusEnum;
import com.easy.hospital.dao.mapper.DoctorMapper;
import com.easy.hospital.dao.model.Department;
import com.easy.hospital.dao.model.Doctor;
import com.easy.hospital.dao.model.Hospital;
import com.easy.hospital.dao.repository.DepartmentRepository;
import com.easy.hospital.dao.repository.DoctorRepository;
import com.easy.hospital.dao.repository.HospitalRepository;
import com.easy.hospital.dto.DoctorListReq;
import com.easy.hospital.dto.DoctorOMSVO;
import com.easy.hospital.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorRepository doctorRepository;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private DepartmentRepository departmentRepository;
    @Resource
    private HospitalRepository hospitalRepository;

    @Override
    public PageInfo<DoctorOMSVO> list(DoctorListReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<Doctor> doctors = doctorRepository.listOnCondition(req);
        PageInfo<Doctor> pageInfo = new PageInfo<>(doctors);
        List<DoctorOMSVO> resList = BeanUtil.copyToList(pageInfo.getList(), DoctorOMSVO.class);
        PageInfo<DoctorOMSVO> info = new PageInfo<>();
        info.setList(resList);
        info.setTotal(pageInfo.getTotal());
        return info;
    }

    @Override
    public void changeStatus(Long id, Integer status) {
        doctorRepository.updateStatusById(id, status);
    }

    @Override
    public Doctor detail(Long id) {
        return doctorRepository.getById(id);
    }

    @Override
    public void deleted(Long id) {
        doctorRepository.deleteLogic(id);
    }

    @Override
    public void saveOrUpdate(Doctor doctor) {
        if (Objects.isNull(doctor.getId())) {
            doctorRepository.save(doctor);
        } else {
            doctorRepository.updateById(doctor);
        }
    }
}

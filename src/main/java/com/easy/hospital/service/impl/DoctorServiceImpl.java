package com.easy.hospital.service.impl;

import cn.hutool.core.bean.BeanUtil;
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
        List<Department> departments = departmentRepository.list();
        Map<Long, String> departmentMap = departments.stream().collect(Collectors.toMap(Department::getId, Department::getDepartmentName));
        List<Hospital> hospitals = hospitalRepository.list();
        Map<Long, String> hospitalMap = hospitals.stream().collect(Collectors.toMap(Hospital::getId, Hospital::getHospitalName));
        List<DoctorOMSVO> voList = doctors.stream().map(doctor -> {
            DoctorOMSVO vo = new DoctorOMSVO();
            BeanUtil.copyProperties(doctor, vo);
            vo.setHospitalName(hospitalMap.get(doctor.getHospitalId()));
            vo.setDepartmentName(departmentMap.get(doctor.getDepartmentId()));
            return vo;
        }).collect(Collectors.toList());
        PageInfo<DoctorOMSVO> info = new PageInfo<>(voList);
        info.setSize(pageInfo.getSize());
        return info;
    }
}

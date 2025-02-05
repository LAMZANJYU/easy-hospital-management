package com.easy.hospital.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.easy.hospital.common.enums.DoctorStatusEnum;
import com.easy.hospital.common.response.ServiceException;
import com.easy.hospital.common.utils.JWTUtils;
import com.easy.hospital.dao.mapper.DoctorMapper;
import com.easy.hospital.dao.model.Department;
import com.easy.hospital.dao.model.Doctor;
import com.easy.hospital.dao.model.Hospital;
import com.easy.hospital.dao.model.SysUser;
import com.easy.hospital.dao.repository.DepartmentRepository;
import com.easy.hospital.dao.repository.DoctorRepository;
import com.easy.hospital.dao.repository.HospitalRepository;
import com.easy.hospital.dto.DoctorListReq;
import com.easy.hospital.dto.DoctorLoginReq;
import com.easy.hospital.dto.DoctorOMSVO;
import com.easy.hospital.dto.LoginReq;
import com.easy.hospital.service.DoctorService;
import com.easy.hospital.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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

    private static final String SALT = "easy-online-hospital";

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

    @Override
    public String login(DoctorLoginReq req) {
        String phone = req.getPhone();
        String password = req.getPassword();
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(password)) {
            throw new ServiceException("400", "用户名或密码不能为空");
        }
        Doctor doctor = doctorRepository.getByPhoneAndPassword(phone, DigestUtils.md5Hex(password + SALT));
        if (Objects.isNull(doctor)) {
            throw new ServiceException("400", "用户名或密码错误");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        map.put("password", DigestUtils.md5Hex(password + SALT));
        return JWTUtils.getToken(map);
    }
}

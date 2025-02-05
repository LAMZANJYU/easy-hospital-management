package com.easy.hospital.service;

import com.easy.hospital.dao.model.Doctor;
import com.easy.hospital.dto.DoctorListReq;
import com.easy.hospital.dto.DoctorLoginReq;
import com.easy.hospital.dto.DoctorOMSVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DoctorService {
    PageInfo<DoctorOMSVO> list(DoctorListReq req);

    void changeStatus(Long id, Integer status);

    Doctor detail(Long id);

    void deleted(Long id);

    void saveOrUpdate(Doctor doctor);

    String login(DoctorLoginReq req);
}

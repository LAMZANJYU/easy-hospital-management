package com.easy.hospital.service;

import com.easy.hospital.dao.model.Hospital;
import com.easy.hospital.dto.HospitalListReq;
import com.github.pagehelper.PageInfo;

public interface HospitalService {
    PageInfo<Hospital> list(HospitalListReq req);

    void saveOrUpdate(Hospital hospital);

    void deleteLogic(Long id);
}

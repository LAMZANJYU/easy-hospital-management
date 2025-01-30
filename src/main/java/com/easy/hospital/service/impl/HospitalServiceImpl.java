package com.easy.hospital.service.impl;

import com.easy.hospital.dao.model.Hospital;
import com.easy.hospital.dao.repository.HospitalRepository;
import com.easy.hospital.dto.HospitalListReq;
import com.easy.hospital.service.HospitalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class HospitalServiceImpl implements HospitalService {
    @Resource
    private HospitalRepository hospitalRepository;

    @Override
    public PageInfo<Hospital> list(HospitalListReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<Hospital> hospitals = hospitalRepository.listOnCondition(req);
        return new PageInfo<>(hospitals);
    }

    @Override
    public void saveOrUpdate(Hospital hospital) {
        if (Objects.isNull(hospital.getId())){
            hospitalRepository.save(hospital);
        } else {
            hospitalRepository.updateById(hospital);
        }
    }

    @Override
    public void deleteLogic(Long id) {
        hospitalRepository.removeById(id);
    }
}

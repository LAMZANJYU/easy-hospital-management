package com.easy.hospital.service.impl;

import com.easy.hospital.dao.model.Hospital;
import com.easy.hospital.dao.repository.HospitalRepository;
import com.easy.hospital.dto.HospitalListReq;
import com.easy.hospital.dto.HospitalWXListReq;
import com.easy.hospital.dto.RecommendHospitalVO;
import com.easy.hospital.service.HospitalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Override
    public List<RecommendHospitalVO> recommendHospital() {
        HospitalListReq req = new HospitalListReq().setStatus(1);
        List<Hospital> hospitals = hospitalRepository.listOnCondition(req);
        List<Hospital> subHospitals = hospitals.subList(0, Math.min(hospitals.size(), 10));
        return subHospitals.stream()
                .map(RecommendHospitalVO::ofHospital)
                .collect(Collectors.toList());
    }

    @Override
    public PageInfo<RecommendHospitalVO> listHospitalWX(HospitalWXListReq req) {
        HospitalListReq listReq = new HospitalListReq()
                .setPageNum(req.getPage())
                .setPageSize(req.getPageSize())
                .setStatus(1)
                .setName(req.getSearch());
        PageHelper.startPage(listReq.getPageNum(), listReq.getPageSize());
        List<Hospital> hospitals = hospitalRepository.listOnCondition(listReq);
        PageInfo<Hospital> pageInfo = new PageInfo<>(hospitals);
        List<RecommendHospitalVO> result = hospitals.stream().map(RecommendHospitalVO::ofHospital).collect(Collectors.toList());
        PageInfo<RecommendHospitalVO> resultInfo = new PageInfo<>();
        resultInfo.setList(result);
        resultInfo.setTotal(pageInfo.getTotal());
        return resultInfo;
    }

    @Override
    public RecommendHospitalVO doctorDeatil(Long id) {
        return RecommendHospitalVO.ofHospital(hospitalRepository.getById(id));
    }
}

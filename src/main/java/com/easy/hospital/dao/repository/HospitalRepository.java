package com.easy.hospital.dao.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.hospital.dao.mapper.HospitalMapper;
import com.easy.hospital.dao.model.Hospital;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalRepository extends ServiceImpl<HospitalMapper, Hospital> {
}

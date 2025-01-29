package com.easy.hospital.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.hospital.dao.model.Hospital;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalMapper extends BaseMapper<Hospital> {
}

package com.easy.hospital.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.hospital.dao.model.Doctor;
import com.easy.hospital.dto.DoctorListReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {
}

package com.easy.hospital.controller.oms;

import com.easy.hospital.common.response.RespResult;
import com.easy.hospital.common.response.RespUtils;
import com.easy.hospital.dao.model.Doctor;
import com.easy.hospital.dto.DoctorListReq;
import com.easy.hospital.dto.DoctorOMSVO;
import com.easy.hospital.service.DoctorService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/easy-online-hospital/doctor")
public class DoctorOMSController {
    @Resource
    private DoctorService doctorService;

    @PostMapping("/list")
    @ApiOperation(value = "医生列表查询")
    public RespResult<PageInfo<DoctorOMSVO>> listDoctor(@RequestBody DoctorListReq req) {
        return RespUtils.success(doctorService.list(req));
    }
}

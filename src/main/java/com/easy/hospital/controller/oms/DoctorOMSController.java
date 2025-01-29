package com.easy.hospital.controller.oms;

import com.easy.hospital.common.response.RespResult;
import com.easy.hospital.common.response.RespUtils;
import com.easy.hospital.dao.model.Doctor;
import com.easy.hospital.dto.DoctorListReq;
import com.easy.hospital.dto.DoctorOMSVO;
import com.easy.hospital.service.DoctorService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/easy-online-hospital/doctor")
@Api(tags = "医生管理")
public class DoctorOMSController {
    @Resource
    private DoctorService doctorService;

    @PostMapping("/list")
    @ApiOperation(value = "医生列表查询")
    public RespResult<PageInfo<DoctorOMSVO>> listDoctor(@RequestBody DoctorListReq req) {
        return RespUtils.success(doctorService.list(req));
    }

    @GetMapping("/status")
    @ApiOperation(value = "修改医生状态")
    public RespResult<Void> changeStatus(@RequestParam Long id, @RequestParam Integer status) {
        doctorService.changeStatus(id, status);
        return RespUtils.success();
    }

    @GetMapping("/detail")
    @ApiOperation(value = "医生详情查询")
    public RespResult<Doctor> detail(@RequestParam Long id) {
        return RespUtils.success(doctorService.detail(id));
    }

    @GetMapping("/deleted")
    @ApiOperation(value = "删除医生")
    public RespResult<Void> deleted(@RequestParam Long id){
        doctorService.deleted(id);
        return RespUtils.success();
    }
}

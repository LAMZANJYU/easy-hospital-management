package com.easy.hospital.controller.oms;

import com.easy.hospital.common.response.RespResult;
import com.easy.hospital.common.response.RespUtils;
import com.easy.hospital.dao.model.Hospital;
import com.easy.hospital.dto.HospitalListReq;
import com.easy.hospital.service.HospitalService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "医院管理")
@RestController
@RequestMapping("/api/easy-online-hospital/hospital")
public class HospitalOMSController {
    @Resource
    private HospitalService hospitalService;

    @ApiOperation(value = "医院列表")
    @PostMapping("/list")
    public RespResult<PageInfo<Hospital>> list(@RequestBody HospitalListReq req){
        return RespUtils.success(hospitalService.list(req));
    }

    @ApiOperation(value = "医院新增或修改")
    @PostMapping("/saveOrUpdate")
    public RespResult<Void> saveOrUpdate(@RequestBody Hospital hospital){
        hospitalService.saveOrUpdate(hospital);
        return RespUtils.success();
    }

    @ApiOperation(value = "医院删除")
    @GetMapping("/delete")
    public RespResult<Void> delete(@RequestParam Long id){
        hospitalService.deleteLogic(id);
        return RespUtils.success();
    }
}

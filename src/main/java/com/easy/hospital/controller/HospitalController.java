package com.easy.hospital.controller;

import com.easy.hospital.common.response.RespResult;
import com.easy.hospital.common.response.RespUtils;
import com.easy.hospital.dto.HospitalWXListReq;
import com.easy.hospital.dto.RecommendHospitalVO;
import com.easy.hospital.service.HospitalService;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wx/hospital")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping("/recommend")
    public RespResult<List<RecommendHospitalVO>> recommendHospital() {
        return RespUtils.success(hospitalService.recommendHospital());
    }

    @PostMapping("/list")
    public RespResult<PageInfo<RecommendHospitalVO>> listHospital(@RequestBody HospitalWXListReq req) {
        return RespUtils.success(hospitalService.listHospitalWX(req));
    }

    @GetMapping("/detail")
    public RespResult<RecommendHospitalVO> detail(@RequestParam Long id) {
        return RespUtils.success(hospitalService.doctorDeatil(id));
    }
}

package com.easy.hospital.controller;

import com.easy.hospital.common.response.RespResult;
import com.easy.hospital.common.response.RespUtils;
import com.easy.hospital.dto.RecommendDoctorVO;
import com.easy.hospital.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/wx/doctor")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/recommend")
    public RespResult<List<RecommendDoctorVO>> recommendDoctor() {
        return RespUtils.success(doctorService.recommendDoctor());
    }
}

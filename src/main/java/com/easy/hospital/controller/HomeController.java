package com.easy.hospital.controller;

import com.easy.hospital.common.response.RespResult;
import com.easy.hospital.common.response.RespUtils;
import com.easy.hospital.dao.model.HomeBanner;
import com.easy.hospital.service.HomeBannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/wx")
public class HomeController {
    @Resource
    private HomeBannerService homeBannerService;

    //首页轮播图
    @GetMapping("/swpiers")
    public RespResult<List<HomeBanner>> getHomeBanner() {
        return RespUtils.success(homeBannerService.getHomeBanner());
    }
}

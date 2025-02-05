package com.easy.hospital.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.easy.hospital.dao.model.HomeBanner;
import com.easy.hospital.dao.repository.HomeBannerRepository;
import com.easy.hospital.service.HomeBannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeBannerServiceImpl implements HomeBannerService {
    @Resource
    private HomeBannerRepository homeBannerRepository;

    @Override
    public List<HomeBanner> getHomeBanner() {
        List<HomeBanner> homeBanners = homeBannerRepository.list();
        if (CollectionUtil.isEmpty(homeBanners)){
            return Collections.emptyList();
        }
        return homeBanners.subList(0, Math.min(homeBanners.size(), 3));
    }
}

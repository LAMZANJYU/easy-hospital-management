package com.easy.hospital.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.hospital.common.response.RespCode;
import com.easy.hospital.common.response.ServiceException;
import com.easy.hospital.common.utils.JWTUtils;
import com.easy.hospital.dao.mapper.SysUserMapper;
import com.easy.hospital.dao.model.SysUser;
import com.easy.hospital.dao.repository.SysUserRepository;
import com.easy.hospital.dto.LoginReq;
import com.easy.hospital.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private SysUserMapper sysUserMapper;

    private static final String slat = "linzhenyu17";
    @Override
    public String login(LoginReq req) {
        String username = req.getUsername();
        String password = req.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new ServiceException("400", "用户名或密码不能为空");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", DigestUtils.md5Hex(password + slat));
        return JWTUtils.getToken(map);
    }

    @Override
    public List<SysUser> list() {
        return sysUserMapper.selectList(null);
    }

    public static void main(String[] args) {
        String password = DigestUtils.md5Hex("linzhenyu17!" + slat);
        System.out.println(password);
    }
}

package com.easy.hospital.service;

import com.easy.hospital.dao.model.SysUser;
import com.easy.hospital.dto.LoginReq;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SysUserService {
    String login(LoginReq req);

    List<SysUser> list();
}

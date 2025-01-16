package com.easy.hospital.controller.oms;

import com.easy.hospital.common.response.RespResult;
import com.easy.hospital.common.response.RespUtils;
import com.easy.hospital.dao.model.SysUser;
import com.easy.hospital.dto.LoginReq;
import com.easy.hospital.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/easy-online-hospital/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    public RespResult<String> login(@RequestBody LoginReq req){
        return RespUtils.success(sysUserService.login(req));
    }

    @GetMapping("/all")
    public RespResult<List<SysUser>> listAll(){
        return RespUtils.success(sysUserService.list());
    }
}

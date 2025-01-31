package com.easy.hospital.controller.oms;

import com.easy.hospital.common.response.RespResult;
import com.easy.hospital.common.response.RespUtils;
import com.easy.hospital.dao.model.Department;
import com.easy.hospital.dto.DepartmentListReq;
import com.easy.hospital.dto.DepartmentVO;
import com.easy.hospital.service.DepartmentService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/easy-online-hospital/department")
public class DepartmentOMSController {
    @Resource
    private DepartmentService departmentService;

    @PostMapping("/list")
    public RespResult<PageInfo<DepartmentVO>> list(@RequestBody DepartmentListReq req) {
        return RespUtils.success(departmentService.list(req));
    }

    @PostMapping("/saveOrUpdate")
    public RespResult<Void> saveOrUpdate(@RequestBody Department department) {
        departmentService.saveOrUpdate(department);
        return RespUtils.success();
    }

    @GetMapping("/delete")
    public RespResult<Void> delete(@RequestParam Long id) {
        departmentService.delete(id);
        return RespUtils.success();
    }
}

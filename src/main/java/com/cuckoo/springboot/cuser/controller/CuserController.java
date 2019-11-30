package com.cuckoo.springboot.cuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cuckoo.springboot.cuser.bean.Cuser;
import com.cuckoo.springboot.cuser.service.CuserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Jasper
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "用户相关接口", tags = {"用户接口"})
public class CuserController {

    @Autowired
    CuserService cuserService;

    @ApiOperation(value = "根据用户名查询用户", notes = "根据用户名查询用户")
    @ApiImplicitParam(name = "username", value = "username", required = true, dataType = "String")
    @GetMapping(value = "/{username}")
    public Cuser getUserByUsername(@PathVariable String username) {
        return cuserService.getOne(Wrappers.<Cuser>lambdaQuery().eq(Cuser::getUsername, username));
    }

}

package com.cuckoo.springboot;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cuckoo.springboot.cuser.bean.Cuser;
import com.cuckoo.springboot.cuser.bean.LoginRequest;
import com.cuckoo.springboot.cuser.bean.RegisterRequest;
import com.cuckoo.springboot.cuser.service.CuserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jasper
 */
@Api(value = "登录相关接口", tags = {"登录相关接口"})
@RestController
public class LoginController {

    @Autowired
    CuserService cuserService;

    @RequestMapping(value = "/login")
    @ApiOperation(value = "用户登录", notes = "用户登录接口", httpMethod = "POST")
    public Cuser login(@RequestBody LoginRequest user) {
        Cuser userInDb = cuserService.getOne(Wrappers.<Cuser>lambdaQuery().eq(Cuser::getUsername, user.getUsername()));
        if (null == userInDb) {
            throw new RuntimeException("用户名不存在");
        }
        if (user.getPwd().equals(userInDb.getPwd())) {
            return userInDb;
        }
        return null;
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "用户注册", notes = "用户注册")
    public Boolean register(@RequestBody RegisterRequest request) {
        Cuser userInDb = cuserService.getOne(Wrappers.<Cuser>lambdaQuery().eq(Cuser::getUsername, request.getUsername()));
        if (null != userInDb) {
            throw new RuntimeException("已存在该用户名");
        }
        Cuser newUser = new Cuser();
        BeanUtils.copyProperties(request, newUser);
        newUser.setIsActive("Y");
        return cuserService.save(newUser);
    }


}

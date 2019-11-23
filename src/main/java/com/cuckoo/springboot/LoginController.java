package com.cuckoo.springboot;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cuckoo.springboot.cuser.bean.Cuser;
import com.cuckoo.springboot.cuser.service.CuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;
import static com.baomidou.mybatisplus.core.toolkit.Wrappers.query;

@RestController
public class LoginController {

    @Autowired
    CuserService cuserService;

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestBody Cuser user) {
        Cuser userInDb = cuserService.getOne(Wrappers.<Cuser>lambdaQuery().eq(Cuser::getUsername, user.getUsername()));
        if (null == userInDb) {
            throw new RuntimeException("用户名不存在");
        }
        if (user.getPwd().equals(userInDb.getPwd())) {
            return null;
        }
        return null;
    }


}

package com.cuckoo.springboot.cuser.service;

import com.cuckoo.springboot.cuser.bean.Cuser;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuckoo.springboot.cuser.dao.CuserMapper;

@Service
public class CuserServiceImpl extends ServiceImpl<CuserMapper, Cuser> implements CuserService{

}

package com.cuckoo.springboot.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cuckoo.springboot.bean.Cuser;
import com.cuckoo.springboot.dao.CuserMapper;
import com.cuckoo.springboot.service.CuserService;
@Service
public class CuserServiceImpl extends ServiceImpl<CuserMapper, Cuser> implements CuserService{

}

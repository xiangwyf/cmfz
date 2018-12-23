package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin queryOne(Admin admin,String enCode,String realCode) {
        Admin admin1 = adminMapper.selectOne(admin);
        try {
            if (admin.getUsername().equals(admin1.getUsername()) && admin.getPassword().equals(admin1.getPassword()) && realCode.equalsIgnoreCase(enCode)) {
                return admin1;
            }
            throw new RuntimeException();
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
}

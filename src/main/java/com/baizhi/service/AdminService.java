package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    public Admin queryOne(Admin admin,String enCode,String realCode);
}

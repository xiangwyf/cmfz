package com.baizhi.service;

import com.baizhi.entity.Distribution;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, List> queryAnalyse() {
        Map<String,List> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(userMapper.queryByDate("7"));
        list.add(userMapper.queryByDate("14"));
        list.add(userMapper.queryByDate("21"));
        List<String> cate = new ArrayList<>();
        cate.add("近一周");
        cate.add("近两周");
        cate.add("近三周");
        map.put("data",list);
        map.put("intervals",cate);
        return map;
    }

    @Override
    public List<Distribution> queryByDistribution() {
        return userMapper.queryByDistribution();
    }
}

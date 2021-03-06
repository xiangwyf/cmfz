package com.baizhi.service;

import com.baizhi.entity.Menu;
import com.baizhi.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryAll() {
        List<Menu> menuList = menuMapper.queryAll();
        return menuList;
    }

    @Override
    public List<Menu> queryById(Menu menu) {
        List<Menu> list = menuMapper.select(menu);
        return list;
    }
}

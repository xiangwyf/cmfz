package com.baizhi.mapper;

import com.baizhi.entity.Distribution;
import com.baizhi.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public Integer queryByDate(String timeAgo);
    public List<Distribution> queryByDistribution();
}

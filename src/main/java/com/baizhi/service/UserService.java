package com.baizhi.service;

import com.baizhi.entity.Distribution;

import java.util.List;
import java.util.Map;

public interface UserService {
    public Map<String, List> queryAnalyse();
    public List<Distribution> queryByDistribution();
}

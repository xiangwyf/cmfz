package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.BannerDto;

import java.util.List;

public interface BannerService {
    public BannerDto queryByPage(int currows,int curpage);
    public void insertBanner(Banner banner);
    public void updateBanner(Banner banner);
    public void deleteBanner(Banner banner);
    public Banner queryOneById(Integer id);
}

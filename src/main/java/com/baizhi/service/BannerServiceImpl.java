package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.BannerDto;
import com.baizhi.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService
{
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public BannerDto queryByPage(int currows,int curpage) {
        BannerDto dto = new BannerDto();
        dto.setTotal(bannerMapper.queryRows());
        dto.setRows(bannerMapper.queryByPage(currows,curpage));
        return dto;
    }

    @Override
    public void insertBanner(Banner banner) {
        banner.setPubDate(new Date());
        bannerMapper.insert(banner);
    }

    @Override
    public void updateBanner(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }
    @Override
    public void deleteBanner(Banner banner){
        bannerMapper.deleteByPrimaryKey(banner);
    }

    @Override
    public Banner queryOneById(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }
}

package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {
    public Integer queryRows();
    public List<Banner> queryByPage(@Param("currows")int currows, @Param("curpage")int curpage);
}

package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.AlbumDto;
import com.baizhi.mapper.AlbumMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public AlbumDto queryByPage(int currows,int curpage) {
        AlbumDto dto = new AlbumDto();
//        PageHelper.startPage(curpage,currows);
        List<Album> albumList = albumMapper.queryByPage(currows,curpage);
        dto.setRows(albumList);
        dto.setTotal(albumMapper.queryCount());
        return dto;
    }

    @Override
    public Album queryOneById(Album album) {
        return albumMapper.selectByPrimaryKey(album);
    }

    @Override
    public void insertAlbum(Album album) {
        album.setId(UUID.randomUUID().toString().replace("-",""));
        albumMapper.insert(album);
    }

    @Override
    public List<Album> queryAll() {
        List<Album> albumList = albumMapper.queryAll();
        return albumList;
    }
}

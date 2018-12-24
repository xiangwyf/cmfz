package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.AlbumDto;

import java.util.List;

public interface AlbumService {
    public AlbumDto queryAll(int currows,int curpage);
    public Album queryOneById(Album album);
    public void insertAlbum(Album album);
}

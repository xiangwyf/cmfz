package com.baizhi.controller;


import com.baizhi.entity.Album;
import com.baizhi.entity.AlbumDto;
import com.baizhi.service.AlbumService;
import com.baizhi.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public AlbumDto queryAll(int rows, int page){
        return albumService.queryAll(rows,page);
    }

    @RequestMapping("/queryOneById")
    @ResponseBody
    public Album queryOneById(Album album){
        return albumService.queryOneById(album);
    }
    @RequestMapping("/insertAlbum")
    @ResponseBody
    public String insertAlbum(Album album, @RequestParam("albumCoverImg") MultipartFile file, HttpSession session){
        String fileName = file.getOriginalFilename();
        String filePath = session.getServletContext().getRealPath("albumImg/");
        try {
            UploadFile.uploadFile(file.getBytes(), filePath, fileName);
            album.setCoverImg("/albumImg/"+fileName);
            albumService.insertAlbum(album);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "defeat";
    }
}

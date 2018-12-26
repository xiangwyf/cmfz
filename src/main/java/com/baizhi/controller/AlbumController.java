package com.baizhi.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Album;
import com.baizhi.entity.AlbumDto;
import com.baizhi.service.AlbumService;
import com.baizhi.util.UploadFile;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public AlbumDto queryAll(int rows, int page){
        return albumService.queryByPage(rows,page);
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

    @RequestMapping("/albumExport")
    @ResponseBody
    public void albumExport(HttpServletResponse response){
        List<Album> albumList = albumService.queryAll();
        for (Album album : albumList) {
            album.setCoverImg("F:/final/cmfz/src/main/webapp"+album.getCoverImg());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑表","专辑"),Album.class,albumList);
        try {
            String encode = URLEncoder.encode("album.xls", "UTF-8");
            response.setHeader("content-disposition","attachment;filename="+encode);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.baizhi.controller;


import com.baizhi.entity.Banner;
import com.baizhi.entity.BannerDto;
import com.baizhi.service.BannerService;
import com.baizhi.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/queryByPage")
    @ResponseBody
    public BannerDto queryByPage(int rows,int page){
        return bannerService.queryByPage(rows,page);
    }

    @RequestMapping("/insertBanner")
    @ResponseBody
    public String insertBanner(Banner banner, @RequestParam("imgFile") MultipartFile file, HttpSession session){
//        if(file.isEmpty()){
//            return "false";
//        }
//        String fileName = file.getOriginalFilename();
//        String path = "F:/img";
//        File dest = new File(path+"/"+fileName);
//        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
//            dest.getParentFile().mkdir();
//        }
//        try {
//            file.transferTo(dest); //保存文件
//            banner.setImgPath(path+"/"+fileName);
//            bannerService.insertBanner(banner);
//            return "true";
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//            return "false";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "false";
//        }
        String fileName = file.getOriginalFilename();
        String filePath = session.getServletContext().getRealPath("img/");
        try {
            UploadFile.uploadFile(file.getBytes(), filePath, fileName);
            banner.setImgPath("/img/"+fileName);
            bannerService.insertBanner(banner);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "defeat";
    }

    @RequestMapping("/updateBanner")
    @ResponseBody
    public void updateBanner(Banner banner){
        bannerService.updateBanner(banner);
    }

    @RequestMapping("/deleteBanner")
    @ResponseBody
    public void deleteBanner(Banner banner){
        bannerService.deleteBanner(banner);
    }
}

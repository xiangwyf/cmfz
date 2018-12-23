package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.ReadVideoTimeUtil;
import com.baizhi.util.UploadFile;
import org.apache.commons.io.FileUtils;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.ogg.util.OggInfoReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/insertChapter")
    @ResponseBody
    public String insertChapter(Chapter chapter, @RequestParam("chapterFile") MultipartFile file, HttpSession session) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = session.getServletContext().getRealPath("chapterDir/");
        byte[] uploadFile = file.getBytes();
        try {

            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath+fileName);
            out.write(uploadFile);
            out.flush();
            out.close();

            chapter.setUrl("/chapterDir/"+fileName);

            chapter.setSize(Integer.toString(uploadFile.length));
            chapter.setDuration(ReadVideoTimeUtil.readVideo(filePath+"/"+fileName));

//            chapter.setDuration("3min");
            chapterService.insertChapter(chapter);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "defeat";
    }
    @RequestMapping("/downChapter")
    public void downChapter(String url, HttpSession session, HttpServletResponse response) throws IOException {
        String[] split = url.split("/");
        String name = split[2];
        String realPath = session.getServletContext().getRealPath("/chapterDir");
        File srcFile = new File(realPath+"/"+name);
        byte[] bs = FileUtils.readFileToByteArray(srcFile);

        // 设置响应头信息，以附件的形式下载
        response.setHeader("content-disposition","attachment; filename=" + URLEncoder.encode(name,"UTF-8"));
        // 使用响应输出流，往client输出文件内容
        ServletOutputStream sos = response.getOutputStream();
        sos.write(bs);
        sos.close();

    }
}

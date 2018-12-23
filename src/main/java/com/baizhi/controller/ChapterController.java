package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.ReadVideoTimeUtil;
import com.baizhi.util.UploadFile;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.ogg.util.OggInfoReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

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
    @ResponseBody
    public void downChapter(Integer id, HttpServletRequest request, HttpServletResponse response){
        Chapter chapter = chapterService.queryOne(id);
        String[] split = chapter.getUrl().split("/");
        String fileName=split[1];
        // 设置文件名，根据业务需要替换成要下载的文件名
//        String fileName = "wo.mp3";
        if (fileName != null) {
            //设置文件路径
            String realPath = "E://downChapter//";
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}

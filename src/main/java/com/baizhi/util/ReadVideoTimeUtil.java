package com.baizhi.util;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import java.io.File;

public class ReadVideoTimeUtil {
    public static String readVideo(String pathname) {
        File source = new File(pathname);
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            System.out.println("此视频时长为:" + ls / 60000 + "分" + (ls % 60000) / 1000 + "秒！");
            return ls / 60000 + "分" + (ls % 60000) / 1000 + "秒";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static Long readVideo1(File source) {
        Encoder encoder = new Encoder();
        long ls = 0;
        MultimediaInfo m;
        try {
            m = encoder.getInfo(source);
            ls = m.getDuration()/1000;

        } catch (Exception e) {
            System.out.println("获取音频时长有误：" + e.getMessage());
        }
        return ls;
    }

}

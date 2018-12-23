package com.baizhi.controller;

import com.baizhi.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/code")
public class CodeController {

    @RequestMapping("/changeCode")
    public void changeCode(HttpSession session, HttpServletResponse response) throws IOException {
        CreateValidateCode cvc = new CreateValidateCode(120, 30, 4, 20);
        String code = cvc.getCode();
        session.setAttribute("code", code.toLowerCase());
        //输出图片
        cvc.write(response.getOutputStream());
    }
}

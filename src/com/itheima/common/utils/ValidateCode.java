package com.itheima.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidateCode extends HttpServlet
{
    //随机生成字符串的数组
    public static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    public static Random random = new Random();

    /**
     * 随机生成验证码字符串
     * @return
     */
    public static String getRandomString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    /**
     * 随机生成颜色
     * @return
     */
    public static Color getRandomColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random
                .nextInt(255));
    }

    /**
     * 获取背景颜色的反色，用于设置字体的颜色
     * @param c
     * @return
     */
    public static Color getReverseColor(Color c) {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c
                .getBlue());
    }

    /**
     * doGet方法
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("image/jpeg");

        String randomString = getRandomString();

        //将生成的验证放到会话里面，便于从会话中提取验证
        request.getSession(true).setAttribute("randomString", randomString);

        int width = 100;
        int height = 30;

        //获得验证码背景颜色
        Color color = getRandomColor();

        //获得验证码字体的颜色，是背景颜色的反色
        Color reverse = getReverseColor(color);

        //在内存中生成图片
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        //获得图片操作工具
        Graphics2D g = bi.createGraphics();

        //设置字体
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));

        //设置图片颜色
        g.setColor(color);

        //填充到背景矩形中
        g.fillRect(0, 0, width, height);

        //设置字体颜色
        g.setColor(reverse);

        //经对应的字符串画到图片里面
        g.drawString(randomString, 18, 20);

        //随机生成背景图片上的混淆点
        for (int i = 0, n = random.nextInt(100); i < n; i++)
        {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }

        // 转成JPEG格式
        ServletOutputStream out = response.getOutputStream();

        //将图片输出到浏览器
        ImageIO.write(bi, "jpeg", out);

        //清空缓存
        out.flush();
    }

}

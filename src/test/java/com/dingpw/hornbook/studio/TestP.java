package com.dingpw.hornbook.studio;

import com.dingpw.hornbook.ApplicationConfigure;
import com.dingpw.hornbook.utils.FileUtil;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;
import sun.font.FontDesignMetrics;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-31 17:46. inCharge@韦宏毅@115477@13811808950
 */
public class TestP {

    public String draw(String target,Font font) throws Exception {
        int imageWidth = 144;
        int imageHeight = 239;
        String text = "你好qq";
        String backColor = "#FFFFFF";
        String foreColor = "#000000";
        String fontId = "123";
        float size = 32.0f;
//        Font font = Painter.buildFont(new File( ApplicationConfigure.getFontTtfDir() + "123.ttf")).deriveFont(Font.BOLD).deriveFont(size);
//        Font font = getFont(fontId).deriveFont(Font.BOLD)
//            .deriveFont(size);
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int[] widthAndHeight = getWidthAndHeight(font, text);// 计算文本所占宽度
        float textWidth = widthAndHeight[0] * 1.2f;// 文本宽度 使用1.2倍率处理
        float textHeight = widthAndHeight[1] * 1.2f;// 文本高度 使用1.2倍率处理

        BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        //设置背影为白色
        graphics.setColor(Color.getColor(backColor));
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setFont(font);
        graphics.setColor(Color.decode(foreColor));
        float startX = (imageWidth - widthAndHeight[0]) / 2;
        float startY = (imageHeight - widthAndHeight[1]) / 2;
//        graphics.drawString(text, startX, metrics.getAscent());//图片上写文字
        graphics.drawString(text, startX, startY);//图片上写文字
        graphics.dispose();

            write(bufferedImage, target);
            return target;

    }

    public static Font getFont(File  name) {
//        Font font = new Font("微软雅黑", Font.BOLD, 32);
        try {
//            String fontUrl = ApplicationConfigure.getFontTtfDir() + name + ".ttf";
            InputStream is = new FileInputStream(name);
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            is.close();
            return font;
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    public static int[] getWidthAndHeight(Font font, String originContent) {
        int[] result = new int[]{0, 0};
        // 按照换行符进行拆解
        String[] originContents = originContent.split("\n");
        // 找出最长的一行
        String maxColumnOfRow = "";
        for (int i = 0; i < originContents.length; i++) {
            if (maxColumnOfRow.length() < originContents[i].length()) {
                maxColumnOfRow = originContents[i];
            }
        }
        // 找出最长的一行的宽度
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int maxWidth = 0;
        for (int i = 0; i < maxColumnOfRow.length(); i++) {
            maxWidth += metrics.charWidth(maxColumnOfRow.charAt(i));
        }
        // 找出最长的一列的高度
        int maxHeight = metrics.getHeight() * originContents.length;
        result[0] = maxWidth;
        result[1] = maxHeight;
        return result;
    }


    public static void write(BufferedImage bufferedImage, String target) throws IOException {
        File file = new File(target);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (OutputStream os = new FileOutputStream(target)) {
            ImageIO.write(bufferedImage, "PNG", os);
        }
    }


}

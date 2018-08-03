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
import sun.font.FontDesignMetrics;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-28 23:18.
 */
public class Painter {


    public static String paintToCloud(int imageWidth,
        int imageHeight,
        String backColor,
        String foreColor,
        File fontTTF,
        float fontSize,
        String content) {
        return paintToCloud(imageWidth, imageHeight, backColor, foreColor, fontTTF, fontSize,
            new String[]{content});
    }

    public static String paintToCloud(int imageWidth,
        int imageHeight,
        String backColor,
        String foreColor,
        File fontTTF,
        float fontSize,
        String[] contents) {
        String bucketName = null;
        String fileName = null;
        try {
            BufferedImage bufferedImage = paint(imageWidth, imageHeight, backColor, foreColor,
                fontTTF, fontSize, contents);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "PNG", byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            bucketName = "hornbook-painter";
            fileName = UUID.randomUUID().toString() + ".png";
            FileUtil.uploadByInputStream(bucketName, fileName, byteArrayInputStream, "image/png");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return ApplicationConfigure.getFileDomain() + bucketName + "/" + fileName;
    }

    public static String paintToLocal(int imageWidth,
        int imageHeight,
        String backColor,
        String foreColor,
        File fontTTF,
        float fontSize,
        String content,
        File target) {
        return paintToLocal(imageWidth, imageHeight, backColor, foreColor, fontTTF, fontSize,
            new String[]{content}, target);
    }

    public static String paintToLocal(int imageWidth,
        int imageHeight,
        String backColor,
        String foreColor,
        File fontTTF,
        float fontSize,
        String[] contents,
        File target) {
        BufferedImage bufferedImage = paint(imageWidth, imageHeight, backColor, foreColor, fontTTF,
            fontSize, contents);
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }
        try (OutputStream os = new FileOutputStream(target)) {
            ImageIO.write(bufferedImage, "PNG", os);
            return target.getAbsolutePath();
        } catch (IOException e) {
            return null;
        }
    }

    private static BufferedImage paint(
        int imageWidth,
        int imageHeight,
        String backColor,
        String foreColor,
        File fontTTF,
        float fontSize,
        String content
    ) {
        return paint(imageWidth, imageHeight, backColor, foreColor, fontTTF, fontSize,
            new String[]{content});
    }

    private static BufferedImage paint(
        int imageWidth,
        int imageHeight,
        String backColor,
        String foreColor,
        File fontTTF,
        float fontSize,
        String[] contents
    ) {
        Color backgroundColor = Color.decode(backColor);
        Color foregroundColor = Color.decode(foreColor);
        Font font = buildFont(fontTTF).deriveFont(Font.BOLD).deriveFont(fontSize);
        BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        //设置背影为白色
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setFont(font);
        graphics.setColor(foregroundColor);

        int[] widthAndHeight = getWidthAndHeight(font, contents);// 计算文本所占宽度
        float startX = (imageWidth - widthAndHeight[0]) / 2;
        float startY = (imageHeight - widthAndHeight[1] * contents.length) / 2;
//         graphics.drawString(contents[0], startX, FontDesignMetrics.getMetrics(font).getAscent());//图片上写文字
        for (String content : contents) {
            graphics.drawString(content, startX, startY);//图片上写文字
            startY = startY + widthAndHeight[1];
        }
        graphics.dispose();
        return bufferedImage;
    }


    protected static Font buildFont(File ttfFile) {
//        Font font = new Font("微软雅黑", Font.BOLD, 32);
//        return font;
        try {
            InputStream is = new FileInputStream(ttfFile);
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

    private static int[] getWidthAndHeight(Font font, String[] originContents) {
        int[] result = new int[]{0, 0};
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
        // 找出一行文字所占的高度
        int maxHeight = metrics.getHeight();
        result[0] = maxWidth;
        result[1] = maxHeight;
        return result;
    }
}

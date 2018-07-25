package com.dingpw.hornbook.painter;

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
 * @author 丁朋伟@600100@18511694468 on 2018-07-24 15:37.
 */
@Service
public class PainterServiceImpl implements IPainterService {

    @Override
    public PainterEntity paint(PainterEntity painterEntity) {
        try {
            String imageUrl = this.draw(painterEntity);
            painterEntity.setImageUrl(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return painterEntity;
    }

    private String draw(PainterEntity painterEntity) throws Exception {
        Font font = getFont(painterEntity.getTtf()).deriveFont(Font.BOLD)
            .deriveFont(painterEntity.getSize());
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int[] widthAndHeight = getWidthAndHeight(font, painterEntity.getContent());// 计算文本所占宽度
        float width = widthAndHeight[0] * 1.2f;// 文本宽度
        float height = widthAndHeight[1] * 1.2f;// 文本高度
        BufferedImage bufferedImage = new BufferedImage((int) width, (int) height,
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        //设置背影为白色
        graphics.setColor(Color.getColor(painterEntity.getBackground()));
        graphics.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics.setFont(font);
        graphics.setColor(Color.decode(painterEntity.getForeground()));
        float startX = (bufferedImage.getWidth() - widthAndHeight[0]) / 2;
        graphics.drawString(painterEntity.getContent(), startX, metrics.getAscent());//图片上写文字
        graphics.dispose();
        String imageUrl = write(bufferedImage);
        return imageUrl;
    }

    public static Font getFont(String name) {
//        Font font = new Font("微软雅黑", Font.BOLD, 32);
        try {
            String fontUrl = ApplicationConfigure.getFontTtfDir() + name;
            InputStream is = new FileInputStream(new File(fontUrl));
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

    public static String write(BufferedImage bufferedImage) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "PNG", byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        String bucketName = "hornbook-painter";
        String fileName = UUID.randomUUID().toString() + ".png";
        FileUtil.uploadByInputStream(bucketName, fileName, byteArrayInputStream, "image/png");
        return ApplicationConfigure.getFileDomain() + bucketName + "/" + fileName;
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

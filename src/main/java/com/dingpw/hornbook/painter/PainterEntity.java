package com.dingpw.hornbook.painter;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-24 15:44.
 */
public class PainterEntity {

    private String background = "#00000000";
    private String foreground = "#000000";
    private String ttf;
    private float size = 32.0f;
    private int style;
    private int width = 128;
    private int height = 128;
    private String content;
    private String imageUrl;

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getForeground() {
        return foreground;
    }

    public void setForeground(String foreground) {
        this.foreground = foreground;
    }

    public String getTtf() {
        return ttf;
    }

    public void setTtf(String ttf) {
        this.ttf = ttf;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

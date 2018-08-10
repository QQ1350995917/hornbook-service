package com.dingpw.hornbook.utils.client.dt;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-07 09:43.
 */
public class DTPainterInput {

    private String Content;
    private String FontInfoId;
    private int ActionCategory = 1;
    private int FontSize = 42;
    private int ImageWidth = 300;
    private int ImageHeight = 100;
    private String FontColor = "#000000";
    private String ImageBgColor = "#FFFFFF";

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getFontInfoId() {
        return FontInfoId;
    }

    public void setFontInfoId(String fontInfoId) {
        FontInfoId = fontInfoId;
    }

    public int getActionCategory() {
        return ActionCategory;
    }

    public void setActionCategory(int actionCategory) {
        ActionCategory = actionCategory;
    }

    public int getFontSize() {
        return FontSize;
    }

    public void setFontSize(int fontSize) {
        FontSize = fontSize;
    }

    public int getImageWidth() {
        return ImageWidth;
    }

    public void setImageWidth(int imageWidth) {
        ImageWidth = imageWidth;
    }

    public int getImageHeight() {
        return ImageHeight;
    }

    public void setImageHeight(int imageHeight) {
        ImageHeight = imageHeight;
    }

    public String getFontColor() {
        return FontColor;
    }

    public void setFontColor(String fontColor) {
        FontColor = fontColor;
    }

    public String getImageBgColor() {
        return ImageBgColor;
    }

    public void setImageBgColor(String imageBgColor) {
        ImageBgColor = imageBgColor;
    }
}

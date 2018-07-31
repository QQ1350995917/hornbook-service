package com.dingpw.hornbook.api.studio;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-06 22:47.
 */
@ApiModel(description = "生成图片的输入参数")
public class PaintingInput {

    @ApiModelProperty(value = "宽度，默认128")
    private int width = 128;
    @ApiModelProperty(value = "高度，默认128")
    private int height = 128;
    @ApiModelProperty(value = "背景色，默认透明")
    private String backColor = "#00000000";
    @ApiModelProperty(value = "前景色，默认黑色")
    private String foreColor = "#000000";
    @ApiModelProperty(value = "字体编号，默认宋体")
    private String fontId;
    @ApiModelProperty(value = "字体名称，默认宋体")
    private String fontName;
    @ApiModelProperty(value = "字号，默认32.0f")
    private float fontSize = 32.0f;
    @ApiModelProperty(hidden = true)
    private int style;
    @ApiModelProperty(value = "字号，默认32.0f")
    private Long userId = 0L;
    @ApiModelProperty(value = "内容", required = true)
    private String content;

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

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public String getForeColor() {
        return foreColor;
    }

    public void setForeColor(String foreColor) {
        this.foreColor = foreColor;
    }

    public String getFontId() {
        return fontId;
    }

    public void setFontId(String fontId) {
        this.fontId = fontId;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package com.dingpw.hornbook.api.painter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-06 22:47.
 */
@ApiModel(description = "生成图片的输入参数")
public class PainterInput {

    @ApiModelProperty(value = "背景色，默认透明")
    private String background = "#00000000";
    @ApiModelProperty(value = "前景色，默认黑色")
    private String foreground = "#000000";
    @ApiModelProperty(value = "字体，默认宋体")
    private String ttf;
    @ApiModelProperty(value = "字号，默认32.0f")
    private float size = 32.0f;
    private int style;
    @ApiModelProperty(value = "宽度，默认128")
    private int width = 128;
    @ApiModelProperty(value = "字号，默认128")
    private int height = 128;
    @ApiModelProperty(value = "内容", required = true)
    private String content;


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
}

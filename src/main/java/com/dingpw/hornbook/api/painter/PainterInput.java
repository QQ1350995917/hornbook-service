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

    @ApiModelProperty(value = "字体", required = true)
    private Long ttfId;
    @ApiModelProperty(value = "文本", required = true)
    private String text;
    @ApiModelProperty(value = "字号，默认22")
    private Long size = 22L;
    @ApiModelProperty(value = "图片的宽度")
    private Long width;
    @ApiModelProperty(value = "图片的高度")
    private Long height;
    @ApiModelProperty(value = "前景色")
    private String foreColor;
    @ApiModelProperty(value = "背景色")
    private String backColor;

    public Long getTtfId() {
        return ttfId;
    }

    public void setTtfId(Long ttfId) {
        this.ttfId = ttfId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getForeColor() {
        return foreColor;
    }

    public void setForeColor(String foreColor) {
        this.foreColor = foreColor;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

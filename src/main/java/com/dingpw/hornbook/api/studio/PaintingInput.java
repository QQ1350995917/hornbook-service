package com.dingpw.hornbook.api.studio;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-06 22:47.
 */
@ApiModel(description = "生成图片的输入参数")
public class PaintingInput {

    @ApiModelProperty(value = "宽度，默认128")
    @NotNull(message = "002001001")
    @Min(message = "002001002", value = 1)
    private int width = 128;

    @ApiModelProperty(value = "高度，默认128")
    @NotNull(message = "002001003")
    @Min(message = "002001004", value = 1)
    private int height = 128;

    @ApiModelProperty(value = "背景色，默认透明")
    @NotBlank(message = "002001005")
    @Pattern(message = "002001006", regexp = "^(#)(\\d){6,8}")
    private String backColor = "#00000000";

    @ApiModelProperty(value = "前景色，默认黑色")
    @NotBlank(message = "002001007")
    @Pattern(message = "002001008", regexp = "^(#)(\\d){6,8}")
    private String foreColor = "#000000";

    @ApiModelProperty(value = "字体编号",required = true)
    @NotNull(message = "002001009")
    @Min(message = "002001010", value = 0)
    private Long fontId;

    @ApiModelProperty(value = "字体名称",required = true)
    @NotBlank(message = "002001011")
    private String fontName;

    @ApiModelProperty(value = "字号，默认32.0f")
    @NotNull(message = "002001012")
    @Min(message = "002001013", value = 1)
    private float fontSize = 32.0f;

    @ApiModelProperty(hidden = true)
    @NotNull(message = "002001014")
    @Min(message = "002001015", value = 0)
    @Max(message = "002001016", value = 0)
    private int style = 0;

    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "002001017")
    @Min(message = "002001018", value = 0)
    private Long userId = 0L;

    @ApiModelProperty(value = "内容", required = true)
    @NotBlank(message = "002001019")
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

    public Long getFontId() {
        return fontId;
    }

    public void setFontId(Long fontId) {
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

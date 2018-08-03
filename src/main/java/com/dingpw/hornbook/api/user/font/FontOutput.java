package com.dingpw.hornbook.api.user.font;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 10:04.
 */
@ApiModel
public class FontOutput {

    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    @ApiModelProperty(value = "字体名称", required = true)
    private String ttfName;
    @ApiModelProperty(value = "简介")
    private String summary;
    @ApiModelProperty(value = "缩略图")
    private String thumb;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTtfName() {
        return ttfName;
    }

    public void setTtfName(String ttfName) {
        this.ttfName = ttfName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}

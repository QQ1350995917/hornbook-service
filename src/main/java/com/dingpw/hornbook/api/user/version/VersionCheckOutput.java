package com.dingpw.hornbook.api.user.version;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-08 19:19.
 */
@ApiModel
public class VersionCheckOutput {

    @NotNull
    private Integer code;
    @NotBlank
    private String name;
    @NotBlank
    private String version;
    @NotBlank
    private String summary;
    @NotBlank
    private String icon;
    @NotBlank
    private String urls;
    @NotBlank
    private String thumbs;
    @NotNull
    private Long updateTime;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getThumbs() {
        return thumbs;
    }

    public void setThumbs(String thumbs) {
        this.thumbs = thumbs;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}

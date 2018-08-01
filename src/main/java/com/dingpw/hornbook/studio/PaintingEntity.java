package com.dingpw.hornbook.studio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-24 15:44.
 */
@Entity
@Table(name = "painting")
@Component
public class PaintingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int width = 128;
    private int height = 128;
    private String background = "#FFFFFF";
    private String foreground = "#000000";
    @NotNull
    private Long fontId;
    @NotNull
    private float fontSize = 32.0f;
    @NotNull(message = "样式，未启用")
    private Long style = 0L;
    @NotBlank
    private String content;
    @NotBlank
    private String imageUrl;
    @NotNull(message = "过期时间，未启用")
    private Long expires = 0L;
    @NotNull(message = "用户ID，未启用")
    private Long userId = 0L;
    @NotNull
    private Long createTime = System.currentTimeMillis();
    @NotNull
    private Long updateTime = System.currentTimeMillis();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getFontId() {
        return fontId;
    }

    public void setFontId(Long fontId) {
        this.fontId = fontId;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public Long getStyle() {
        return style;
    }

    public void setStyle(Long style) {
        this.style = style;
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

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}

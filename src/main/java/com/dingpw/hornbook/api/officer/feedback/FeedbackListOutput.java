package com.dingpw.hornbook.api.officer.feedback;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 19:02.
 */
public class FeedbackListOutput extends FeedbackReplyInput {

    @ApiModelProperty(value = "类型，默认值0")
    @NotBlank(message = "003001001")
    private String type = "默认类型";
    @ApiModelProperty(value = "标题，默认值")
    @NotBlank(message = "003001002")
    private String title = "默认标题";
    @ApiModelProperty(value = "反馈内容", required = true)
    @NotBlank(message = "003001003")
    private String content;
    @ApiModelProperty(value = "用户ID，默认0", required = true)
    @NotNull(message = "003001004")
    private Long userId = 0L;
    @ApiModelProperty(value = "用户名称，默认0")
    @NotBlank(message = "003001005")
    private String userName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

package com.dingpw.hornbook.api.officer.feedback;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 18:30.
 */
public class FeedbackReplyInput {

    @ApiModelProperty(value = "ID")
    @NotBlank(message = "003001001")
    private String id;
    @ApiModelProperty
    private Long replyId;
    @ApiModelProperty
    private String replyContent;
    @ApiModelProperty
    private Long createTime;
    @ApiModelProperty
    private Long updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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

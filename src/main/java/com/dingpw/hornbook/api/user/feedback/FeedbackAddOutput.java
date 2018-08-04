package com.dingpw.hornbook.api.user.feedback;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 10:15.
 */
@ApiModel
public class FeedbackAddOutput extends FeedbackAddInput {
    @ApiModelProperty(value = "ID")
    private Long id = 0L;
    @ApiModelProperty
    private Long replyId;
    @ApiModelProperty
    private String replyContent;
    @ApiModelProperty
    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}

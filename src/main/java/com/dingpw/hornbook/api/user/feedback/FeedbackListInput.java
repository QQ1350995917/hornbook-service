package com.dingpw.hornbook.api.user.feedback;

import com.dingpw.hornbook.api.PagingInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 10:22.
 */
@ApiModel(value = "userFeedbackListInput")
public class FeedbackListInput extends PagingInput {

    @ApiModelProperty(required = true)
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

package com.dingpw.hornbook.api.officer.feedback;

import com.dingpw.hornbook.api.PagingInput;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 18:39.
 */
public class FeedbackListInput extends PagingInput {

    private Long status;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}

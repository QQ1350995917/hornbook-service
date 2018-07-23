package com.dingpw.hornbook.api.font;

import com.dingpw.hornbook.api.PagingInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 10:00.
 */
@ApiModel
public class FontListInput {

    @ApiModelProperty(value = "页码信息，默认值")
    private PagingInput paging = new PagingInput();

    public PagingInput getPaging() {
        return paging;
    }

    public void setPaging(PagingInput paging) {
        this.paging = paging;
    }
}

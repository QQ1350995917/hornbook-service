package com.dingpw.hornbook.api.studio;

import com.dingpw.hornbook.api.PagingInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-30 13:59.
 */
@ApiModel
public class PaintingListInput {

    @ApiModelProperty(value = "用户ID", required = true)
    @NotNull(message = "002002001")
    @Min(message = "002002002", value = 0)
    private Long userId;
    @ApiModelProperty(value = "分页信息，默认值")
    @NotNull(message = "002002003")
    @Valid
    private PagingInput paging = new PagingInput();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PagingInput getPaging() {
        return paging;
    }

    public void setPaging(PagingInput paging) {
        this.paging = paging;
    }
}

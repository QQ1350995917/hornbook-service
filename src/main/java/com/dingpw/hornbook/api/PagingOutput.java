package com.dingpw.hornbook.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 09:37.
 */
@ApiModel
public class PagingOutput extends PagingInput {

    @ApiModelProperty(value = "总页码量", required = true)
    private int totalIndex;
    @ApiModelProperty(value = "总数据量", required = true)
    private int totalSize;

    public PagingOutput(PagingInput input) {
        BeanUtils.copyProperties(input,this);
    }

    public int getTotalIndex() {
        return totalIndex;
    }

    public void setTotalIndex(int totalIndex) {
        this.totalIndex = totalIndex;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}

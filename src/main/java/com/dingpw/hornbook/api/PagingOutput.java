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
    private Long totalIndex;
    @ApiModelProperty(value = "总数据量", required = true)
    private Long totalSize;

    public PagingOutput() {
        super();
    }

    public PagingOutput(PagingInput input) {
        BeanUtils.copyProperties(input, this);
    }

    public PagingOutput(int index, int size, Long totalIndex, Long totalSize) {
        super(index, size, 0, 0);
        this.totalIndex = totalIndex;
        this.totalSize = totalSize;
    }

    public Long getTotalIndex() {
        return totalIndex;
    }

    public void setTotalIndex(Long totalIndex) {
        this.totalIndex = totalIndex;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }
}

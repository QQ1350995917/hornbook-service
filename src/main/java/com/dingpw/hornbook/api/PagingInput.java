package com.dingpw.hornbook.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 09:37.
 */
@ApiModel
public class PagingInput {

    @ApiModelProperty(value = "页码，默认值0")
    private int index = 0;
    @ApiModelProperty(value = "页面容量，默认16")
    private int size = 16;
    @ApiModelProperty(value = "排序条件")
    private int sort;
    @ApiModelProperty(value = "过滤条件")
    private int filter;

    public int getIndex() {
        return index < 0 ? 0 : index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size < 1 ? 16 : size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }
}

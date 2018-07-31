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
    private int sort = 0;
    @ApiModelProperty(value = "过滤条件")
    private int filter = 0;


    public PagingInput(int index, int size, int sort, int filter) {
        this.index = index;
        this.size = size;
        this.sort = sort;
        this.filter = filter;
    }

    public PagingInput() {
        super();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
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

package com.dingpw.hornbook.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 09:37.
 */
@ApiModel
public class PagingInput {

    @ApiModelProperty(value = "页码，默认值0")
    @NotNull(message = "000000001")
    @Min(message = "000000002",value = 0)
    private int index = 0;

    @ApiModelProperty(value = "页面容量，默认16")
    @NotNull(message = "000000003")
    @Min(message = "000000004",value = 1)
    private int size = 16;

    @ApiModelProperty(value = "排序条件")
    @NotNull(message = "000000005")
    @Min(message = "000000006",value = 0)
    @Max(message = "000000007",value = 0)
    private int sort = 0;

    @ApiModelProperty(value = "过滤条件")
    @NotNull(message = "000000008")
    @Min(message = "000000009",value = 0)
    @Max(message = "000000010",value = 0)
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

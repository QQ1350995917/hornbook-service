package com.dingpw.hornbook.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 10:27.
 */
@ApiModel
public class ListOutput<T> {

    @ApiModelProperty(value = "页码信息", required = true)
    private PagingOutput paging;
    @ApiModelProperty(value = "数据信息", required = true)
    private List<T> list;

    public PagingOutput getPaging() {
        return paging;
    }

    public void setPaging(PagingOutput paging) {
        this.paging = paging;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

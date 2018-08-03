package com.dingpw.hornbook.api.user.studio;

import com.dingpw.hornbook.api.PagingOutput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-30 14:00.
 */
@ApiModel
public class PaintingListOutput {

    @ApiModelProperty(value = "页码信息", required = true)
    private PagingOutput paging;
    @ApiModelProperty(value = "数据信息", required = true)
    private List<PaintingOutput> paintings;

    public PagingOutput getPaging() {
        return paging;
    }

    public void setPaging(PagingOutput paging) {
        this.paging = paging;
    }

    public List<PaintingOutput> getPaintings() {
        return paintings;
    }

    public void setPaintings(List<PaintingOutput> paintings) {
        this.paintings = paintings;
    }
}

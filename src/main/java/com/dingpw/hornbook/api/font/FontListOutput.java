package com.dingpw.hornbook.api.font;

import com.dingpw.hornbook.api.PagingOutput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-19 10:01.
 */
@ApiModel
public class FontListOutput {

    @ApiModelProperty(value = "页码信息", required = true)
    private PagingOutput paging;
    @ApiModelProperty(value = "数据信息", required = true)
    private List<FontOutput> fonts;

    public PagingOutput getPaging() {
        return paging;
    }

    public void setPaging(PagingOutput paging) {
        this.paging = paging;
    }

    public List<FontOutput> getFonts() {
        return fonts;
    }

    public void setFonts(List<FontOutput> fonts) {
        this.fonts = fonts;
    }
}

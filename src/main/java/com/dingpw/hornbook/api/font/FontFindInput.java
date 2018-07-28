package com.dingpw.hornbook.api.font;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-27 16:04.
 */
@ApiModel
public class FontFindInput {
    @ApiModelProperty(value = "fontId，默认值")
    private Long fontId;

    public Long getFontId() {
        return fontId;
    }

    public void setFontId(Long fontId) {
        this.fontId = fontId;
    }
}

package com.dingpw.hornbook.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-06 22:56.
 */
@ApiModel
public class Meta {

    @NotNull(message = "400")
    @ApiModelProperty(value = "响应code",required = true)
    private int code = 200;

    @NotBlank(message = "400")
    @ApiModelProperty(value = "提示信息",required = true)
    private String message = "ok";


    public Meta() {
        super();
    }

    public Meta(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Meta successMeta(){
        return new Meta();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
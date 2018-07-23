package com.dingpw.hornbook.api;

import com.dingpw.hornbook.exception.BaseException;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-06 22:55.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Output<T> {

    private T data;

    private Meta meta;

    public Output(T data) {
        this.meta = Meta.successMeta();
        this.data = data;
    }

    public Output(Meta meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * @param data
     * @return
     */
    public static Output output(Object data) {
        return new Output(Meta.successMeta(), data);
    }

    /**
     * @param code
     * @param errorMessage
     * @param data
     * @return
     */
    public static Output error(int code, String errorMessage, Object data) {
        throw new BaseException(code, errorMessage);
    }
}

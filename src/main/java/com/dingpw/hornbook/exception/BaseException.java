package com.dingpw.hornbook.exception;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-06 22:56.
 */
public class BaseException extends RuntimeException {
    private Integer statusCode;
    private String errorMessage;
    private MessageKey msgKey;

    public BaseException(String errorMessage) {
        super(errorMessage, (Throwable)null, false, false);
        this.errorMessage = errorMessage;
    }

    public BaseException(Integer statusCode, String errorMessage) {
        super(errorMessage, (Throwable)null, false, false);
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(Integer statusCode, String errorMessage, Throwable e) {
        super(errorMessage, e, false, false);
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(MessageKey msgKey, String errorMessage) {
        super(errorMessage, (Throwable)null, false, false);
        this.msgKey = msgKey;
        this.errorMessage = errorMessage;
    }

    public BaseException(MessageKey msgKey) {
        super((String)null, (Throwable)null, false, false);
        this.msgKey = msgKey;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public MessageKey getMessageKey() {
        return this.msgKey;
    }
}

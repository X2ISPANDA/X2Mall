package com.xmy.common.exception;

/**
 * Talk is cheap,show me the code.
 *
 * @Description:
 * @Author: X2
 * @Date: 2020/8/3 18:49
 */
public enum BizCodeEnum {
    /**
     * 未知错误
     */
    UNKNOW_EXCEPTION(10000, "系统未知异常"),
    /**
     * 数据校验错误
     */
    VALID_EXCEPTION(10001, "参数格式校验失败");

    /**
     * 错误状态码
     */
    private int code;

    /**
     * 错误消息
     */
    private String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

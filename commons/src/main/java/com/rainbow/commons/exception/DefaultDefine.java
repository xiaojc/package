package com.rainbow.commons.exception;

/**
 * Created by Admin on 2016/7/4.
 */
public enum DefaultDefine implements CodeAndMsg {
    SUCCESS("000000", "成功"),
    SYSTEM_ERROR("999999", "系统繁忙，请稍后再试"),
    READ_TIME_OUT_FAIL("009999", "服务请求超时"),
    CONNECTION_TIME_OUT_FAIL("009998", "服务连接超时"),
    CONNECTION_ERROR_FAIL("009997", "服务连接异常"),
    CONNECTION_REFUSE_FAIL("009998", "服务连接被拒绝"),
    REQUEST_PARAM_EMPTY("049999", "请求参数不能为空"),
    COMMAND_NOT_FOUND_ERROR("099999", "系统繁忙，请稍后再试");

    private String responseCode;
    private String responseMsg;

    private DefaultDefine(String responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public String getResponseCode() {
        return null;
    }

    public String getResponseMsg() {
        return null;
    }
}

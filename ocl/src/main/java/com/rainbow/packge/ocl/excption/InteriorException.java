package com.rainbow.packge.ocl.excption;

import com.rainbow.packge.ocl.constants.CodeAndMsg;

/**
 * 小贷内部异常
 * @author zhouliangfei
 * @date 15-8-17 上午10:53
 */
public class InteriorException extends Exception {

    private String responseCode;

    private String responseMsg;

    public InteriorException(String message) {
        super(message);
        this.responseMsg = message;
    }

    public InteriorException(String responseCode, String responseMsg) {
        super("[" + responseCode + "] " + responseMsg);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public InteriorException(String responseCode, String responseMsg, Throwable e) {
        super("[" + responseCode + "] " + responseMsg, e);
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public InteriorException(CodeAndMsg codeAndMsg) {
        super("[" + codeAndMsg.getResponseCode() + "] " + codeAndMsg.getResponseMsg());
        this.responseCode = codeAndMsg.getResponseCode();
        this.responseMsg = codeAndMsg.getResponseMsg();
    }

    public InteriorException(CodeAndMsg codeAndMsg, Throwable e) {
        super("[" + codeAndMsg.getResponseCode() + "] " + codeAndMsg.getResponseMsg(), e);
        this.responseCode = codeAndMsg.getResponseCode();
        this.responseMsg = codeAndMsg.getResponseMsg();
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMsg() {
        return this.responseMsg;
    }
}

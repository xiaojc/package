package com.rainbow.packge.ocl.constants;

/**
 * 小贷统一返回码定义类
 * @author xiaojc
 * @date 上午10:49
 */
public enum DefaultDefine implements CodeAndMsg {

    //###############################BEGIN   统一返回##############################
    //成功
    SUCCESS("000000", "成功"),

    //无法归类的异常统一为返回系统异常
    SYSTEM_ERROR("999999","系统繁忙，请稍后再试"),

    //传入的请求参数对象为空时使用该错误
    REQUEST_PARAM_EMPTY("049999", "请求参数不能为空"),


    //以下为重新规划后的统一异常定义===============================

    //无法归类的异常统一为返回系统异常
    COMMAND_NOT_FOUND_ERROR("099999","系统繁忙，请稍后再试"),
    //command 服务不存在
    COMMAND_BEAN_NOT_FOUND_ERROR("019999","系统繁忙，请稍后再试"),
    //command 服务返回为空
    COMMAND_RETURN_NULL_ERROR("029999","系统繁忙，请稍后再试"),
    //command 参数不能为空
    COMMAND_PARAM_NOT_NULL_FAIL("039999", "{0}参数不能为空"),
    COMMAND_PARAM_NOT_FILLED_FAIL("039999", "请填写{0}"),
    COMMAND_PARAM_NOT_SELECTED_FAIL("039999", "请选择{0}"),
    //command 参数不能为空
    COMMAND_PARAM_FAIL("039999", "{0}参数错误"),
    COMMAND_UNKNOWN_CHANNEL_FAIL("039998", "{0}参数错误"),
    COMMAND_DATA_FORMAT_FAIL("039999", "{0}时间格式不正确"),

    //command 参数不为数字
    COMMAND_NUM__FAIL("039999", "{0}为无效数字"),
    //command 无效参数
    COMMAND_PARAMETER_FAIL("049999","无效参数"),
  //command 无效参数
    COMMAND_TYPE_FAIL("049999","贷款类型无效"),
    //command 参数转换为对象失败
    COMMAND_CONVERT_FAIL("049999","无效参数"),

    //一些公共的参数校验
    // command userCode 不能为空
    COMMAND_USER_CODE_EMPTY("039999", "客户号不能为空"),
    // command prodId 不能为空
    COMMAND_PROD_ID_EMPTY("039999", "产品类型不能为空"),
    //数据库操作到账的异常处理
    DATABASE_OPERATE_ERROR("069999", "系统繁忙，请稍后再试"),

    // 调用接口超时异常返回码定义
    READ_TIME_OUT_FAIL("009999", "读取超时"),
    //###############################END   统一返回##############################

    //#####################账户类##############################
    // 错误码定义范围(010001 - 010100)
    ACCOUNT_NOT_FOUND_FAIL("010001", "账户不存在"),
    ACCOUNT_BANKCARD_NOT_FOUND_FAIL("010002", "用户的银行卡不存在"),

    //#####################账户类##############################

    //#####################参数校验类##############################
    // 错误码定义范围(010101 - 010200)
    //md5验证错误
    MD5_FAIL("020001","验签错误"),
    //高级实名认证接口，userCode为用户手机号
    GUEST_NOT_LOGIN_FAIL("020002","请游客先登录"),


    //add by xiaojiancao 2015-12-29 14:56:59 金额校验
    AMOUNT_INPUT_FAIL("010101","请输入正确的金额"),
    //end by xiaojiancao 2015-12-29 14:56:59 金额校验
    //#####################参数校验类##############################
    //AES对称加密失败
    AES_ENCRYPT_FAIL("020009","加密错误"),
    //AES对称解密失败
    AES_DECRYPT_FAIL("020010","解密错误"),
    ;
    private String responseCode;  //响应码
    private String responseMsg;//响应解释

    DefaultDefine(String responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    @Override
    public String getResponseCode() {
        return this.responseCode;
    }

    @Override
    public String getResponseMsg() {
        return this.responseMsg;
    }
}
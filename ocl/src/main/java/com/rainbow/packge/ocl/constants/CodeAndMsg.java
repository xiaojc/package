package com.rainbow.packge.ocl.constants;

/**
 *  返回码和返回信息获取接口
 *  @author xiaojc
 *  @version 1.0
 */
public interface CodeAndMsg {

    //参数验证的统一返回码， 如参数不能为空，参数类型错误，参数格式错误等
    public static final String PARAM_CHECK_CODE="039999";

    public String getResponseCode();
    public String getResponseMsg();
}

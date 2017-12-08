package com.mc.common.api;

/**
 * 响应结果基类
 *
 * @author huchiwei
 * @version 1.0.0
 */
public class ResponseData {

    /**
     * 返回码：00   请求失败
     * 返回码：01   请求成功
     * 返回码：02   用户名或密码错误
     * 返回码：03   请求协议参数不完整
     * 返回码：04   Token验证失败
     * 返回码：05       请求超时
     */
    private String result;                             // 是否请求错误


    // ==================================================================
    // setter/getter ====================================================
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

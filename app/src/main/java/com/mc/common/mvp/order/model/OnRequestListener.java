package com.mc.common.mvp.order.model;

/**
 * @类名称：OnRequestListener
 * @单位：安徽米创信息技术有限公司
 * @联系人：朱世闯
 * @联系方式：zsc@micjs.com
 * @创建时间：2017/11/16.
 * @功能描述：
 */
public interface OnRequestListener {

    void onSuccess(String s);

    void onError(String s);
}

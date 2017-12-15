package com.mc.common.mvp.order.model;

import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;
import com.mc.common.mvp.order.bean.WeChatBean;


/**
 * Created by Administrator on 2017/4/17.
 * @author momologo
 */

public class WeChatPayTools {


    public static void doWXPay(final Context mContext, String wx_appid, WeChatBean pay_param, final OnRequestListener onRxHttpString) {
        WeChatPay.init(mContext, wx_appid);//要在支付前调用
        WeChatPay.getInstance().doPay(pay_param, new WeChatPay.WXPayResultCallBack() {
            @Override
            public void onSuccess() {
                ToastUtils.showShort("微信支付成功");
                onRxHttpString.onSuccess("微信支付成功");
            }

            @Override
            public void onError(int error_code) {
                switch (error_code) {
                    case WeChatPay.NO_OR_LOW_WX:
                        ToastUtils.showShort("未安装微信或微信版本过低");
                        onRxHttpString.onError("未安装微信或微信版本过低");
                        break;

                    case WeChatPay.ERROR_PAY_PARAM:
                        ToastUtils.showShort("参数错误");
                        onRxHttpString.onError("参数错误");
                        break;

                    case WeChatPay.ERROR_PAY:
                        ToastUtils.showShort("支付失败");
                        onRxHttpString.onError("支付失败");
                        break;
                }
            }

            @Override
            public void onCancel() {
                ToastUtils.showShort("支付取消");
                onRxHttpString.onError("支付取消");
            }
        });
    }
}

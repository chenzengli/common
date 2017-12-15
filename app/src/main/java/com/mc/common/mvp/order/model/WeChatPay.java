package com.mc.common.mvp.order.model;

import android.content.Context;

import com.mc.common.mvp.order.bean.WeChatBean;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 微信支付
 * Created by tsy on 16/6/1.
 */
public class WeChatPay {

    public static final int NO_OR_LOW_WX = 1;   //未安装微信或微信版本过低
    public static final int ERROR_PAY_PARAM = 2;  //支付参数错误
    public static final int ERROR_PAY = 3;  //支付失败
    private static WeChatPay sMWechatPay;
    private IWXAPI mWXApi;
    private WeChatBean mPayParam;
    private WXPayResultCallBack mCallback;

    public WeChatPay(Context context, String wx_appid) {
        mWXApi = WXAPIFactory.createWXAPI(context, null);
        mWXApi.registerApp(wx_appid);
    }

    public static void init(Context context, String wx_appid) {
        if (sMWechatPay == null) {
            sMWechatPay = new WeChatPay(context, wx_appid);
        }
    }

    public static WeChatPay getInstance() {
        return sMWechatPay;
    }


    /**
     * 发起微信支付
     */
    public void doPay(WeChatBean pay_param, WXPayResultCallBack callback) {
        mPayParam = pay_param;
        mCallback = callback;

        if (!check()) {
            if (mCallback != null) {
                mCallback.onError(NO_OR_LOW_WX);
            }
            return;
        }


        PayReq req = new PayReq();
        req.appId = mPayParam.getAppid();
        req.partnerId = mPayParam.getPartnerid();
        req.prepayId = mPayParam.getPrepayid();
        req.packageValue = mPayParam.getPackageX();
        req.nonceStr = mPayParam.getNoncestr();
        req.timeStamp = mPayParam.getTimestamp();
        req.sign = mPayParam.getSign();

        mWXApi.sendReq(req);
    }

    //支付回调响应
    public void onResp(int error_code) {
        if (mCallback == null) {
            return;
        }

        if (error_code == 0) {   //成功
            mCallback.onSuccess();
        } else if (error_code == -1) {   //错误
            mCallback.onError(ERROR_PAY);
        } else if (error_code == -2) {   //取消
            mCallback.onCancel();
        }

        mCallback = null;
    }

    //检测是否支持微信支付
    private boolean check() {
        return mWXApi.isWXAppInstalled() && mWXApi.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
    }

    public interface WXPayResultCallBack {
        void onSuccess(); //支付成功

        void onError(int error_code);   //支付失败

        void onCancel();    //支付取消
    }
}

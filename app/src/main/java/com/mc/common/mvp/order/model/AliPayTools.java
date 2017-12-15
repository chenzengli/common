package com.mc.common.mvp.order.model;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.ToastUtils;
import com.mc.common.mvp.order.bean.PayResult;

import java.util.Map;


/**
 * @类名称：AliPayTools
 * @单位：安徽米创信息技术有限公司
 * @联系人：朱世闯
 * @联系方式：zsc@micjs.com
 * @创建时间：2017/11/30
 * @功能描述：
 */
public class AliPayTools {

    private static final int SDK_PAY_FLAG = 1;


    private static OnRequestListener sOnRequestListener;
    @SuppressLint("HandlerLeak")
    private static Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);

                    //对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。

                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        sOnRequestListener.onSuccess(resultStatus);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        sOnRequestListener.onError(resultStatus);
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };


    /**
     * @param activity  当前支付activity
     * @param onRequestListener 回调接口
     * @param orderInfo 订单信息
     * @return  没有返回
     * @throws
     * @方法名称： aliPay
     * @方法描述：
     * @联系人： 朱世闯
     * @联系方式： zsc@micjs.com
     * @创建时间： 2017/11/30
     */
    public static void aliPay(final Activity activity, final String orderInfo, OnRequestListener onRequestListener) {
        sOnRequestListener = onRequestListener;
        if (TextUtils.isEmpty(orderInfo)) {
            ToastUtils.showShort("订单号为空，请稍后再试");
            return;
        }
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}

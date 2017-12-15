package com.mc.common.wxapi;


import android.app.Activity;

import com.mc.common.mvp.order.model.WeChatPay;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp != null) {
            WeChatPay.getInstance().onResp(resp.errCode);
            this.finish();
        }
    }
}

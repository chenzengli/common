package com.mc.common.mvp.order.view;

import com.mc.common.base.BaseView;
import com.mc.common.mvp.order.bean.WeChatBean;

/**
 * Created by momologo on 2017/12/13 14:09.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface PayView extends BaseView {

    void startPayInfo();

    void aliPaySuccess(String orderInfo);

    void weChatPaySuccess(WeChatBean weChatBean);

    void unionPaySuccess(String tn);

    void payInfoFail(String errorInfo);

}

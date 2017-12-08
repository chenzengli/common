package com.mc.common.mvp.order.presenter;

import com.mc.common.base.BasePresenter;

import java.util.Map;

/**
 * Created by momologo on 2017/12/7 10:01.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseOrderPresenter extends BasePresenter {

    void getOrderList(Map<String, String> pMap);

    void getOrderDetail(Map<String, String> pMap);

    void cancelOrder(Map<String, String> pMap);

    void noticeSend(Map<String, String> pMap);

    void confirmReceipt(Map<String, String> pMap);

    void evaluate(Map<String, String> pMap);

    void payInfo(Map<String, String> pMap);

    void logistics(Map<String, String> pMap);
}

package com.mc.common.mvp.order.model;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseModel;

import java.util.Map;

import rx.Observable;

/**
 * Created by momologo on 2017/12/7 9:30.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseOrderModel<T extends BaseBean> extends BaseModel {

    Observable<T> getOrderList(Map<String, String> pMap);

    Observable<T> getOrderDetail(Map<String, String> pMap);

    Observable<T> cancelOrder(Map<String, String> pMap);

    Observable<T> noticeSend(Map<String, String> pMap);

    Observable<T> confirmReceipt(Map<String, String> pMap);

    Observable<T> evaluate(Map<String, String> pMap);

    Observable<T> payInfo(Map<String, String> pMap);

    Observable<T> logistics(Map<String, String> pMap);

}

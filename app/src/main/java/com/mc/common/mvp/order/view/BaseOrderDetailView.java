package com.mc.common.mvp.order.view;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseView;

/**
 * Created by momologo on 2017/12/7 9:24.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseOrderDetailView<T extends BaseBean, K extends Exception> extends BaseView {

    void startLoadDetail();

    void loadDetailSuccess(T t);

    void loadDetailFail(K k);

}

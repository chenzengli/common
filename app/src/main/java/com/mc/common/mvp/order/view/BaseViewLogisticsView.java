package com.mc.common.mvp.order.view;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseView;

/**
 * Created by momologo on 2017/12/6 18:39.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseViewLogisticsView<T extends BaseBean, K extends Exception> extends BaseView {

    void startViewLogistics();

    void viewLogisticsSuccess(T t);

    void viewLogisticsFail(K k);

}

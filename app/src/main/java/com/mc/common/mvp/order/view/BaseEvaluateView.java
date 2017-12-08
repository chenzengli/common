package com.mc.common.mvp.order.view;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseView;

/**
 * Created by momologo on 2017/12/6 18:41.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseEvaluateView<T extends BaseBean, K extends Exception> extends BaseView {

    void startEvaluate();

    void evaluateSuccess(T t);

    void evaluateFail(K k);
}

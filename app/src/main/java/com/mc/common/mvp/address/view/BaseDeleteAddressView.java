package com.mc.common.mvp.address.view;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseView;

/**
 * Created by momologo on 2017/12/6 16:59.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseDeleteAddressView<T extends BaseBean, K extends Exception> extends BaseView {

    void startDelete();

    void deleteSuccess(T t);

    void deleteFail(K k);
}

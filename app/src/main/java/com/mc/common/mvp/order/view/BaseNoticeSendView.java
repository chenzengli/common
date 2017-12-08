package com.mc.common.mvp.order.view;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseView;

/**
 * Created by momologo on 2017/12/6 18:31.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseNoticeSendView<T extends BaseBean, K extends Exception> extends BaseView {

    void startNotice();

    void noticeSuccess(T t);

    void noticeFail(K k);

}

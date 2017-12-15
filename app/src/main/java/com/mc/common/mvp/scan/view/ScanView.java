package com.mc.common.mvp.scan.view;

import com.mc.common.base.BaseView;

/**
 * Created by momologo on 2017/12/12 14:59.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface ScanView extends BaseView {

    void startCheck();

    void checkSuccess(String info);

    void checkFail(String info);

    void checkError(String errorInfo);
    
}

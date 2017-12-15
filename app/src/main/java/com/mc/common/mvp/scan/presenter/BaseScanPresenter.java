package com.mc.common.mvp.scan.presenter;

import com.mc.common.base.BasePresenter;

import java.util.Map;

/**
 * Created by momologo on 2017/12/12 15:48.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseScanPresenter extends BasePresenter {

    void checkScanContent(Map<String, String> pMap);

}

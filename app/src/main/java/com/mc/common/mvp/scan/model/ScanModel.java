package com.mc.common.mvp.scan.model;

import com.mc.common.base.BaseBean;

import java.util.Map;

import rx.Observable;

/**
 * Created by momologo on 2017/12/12 15:51.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public class ScanModel implements BaseScanModel<BaseBean> {

    @Override
    public Observable<BaseBean> checkScanContent(Map<String, String> pMap) {

        return null;
    }
}

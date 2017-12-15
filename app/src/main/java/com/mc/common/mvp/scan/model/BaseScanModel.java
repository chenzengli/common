package com.mc.common.mvp.scan.model;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseModel;

import java.util.Map;

import rx.Observable;

/**
 * Created by momologo on 2017/12/12 15:02.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseScanModel<T extends BaseBean> extends BaseModel {

    Observable<T> checkScanContent(Map<String, String> pMap);

}

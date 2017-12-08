package com.mc.common.mvp.address.model;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseModel;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by momologo on 2017/12/5 14:53.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseAddressModel<T extends BaseBean> extends BaseModel {

    Observable<T> loadAddressList(Map<String, String> pMap);

    Observable<T> setDefault(Map<String, String> pMap);

    Observable<T> deleteAddress(Map<String, String> pMap);

    Observable<T> editAddress(Map<String, String> pMap);

    Observable<T> addAddress(Map<String, String> pMap);

    Observable<T> loadArea(Map<String, String> pMap);
}

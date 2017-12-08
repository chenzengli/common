package com.mc.common.mvp.address.presenter;

import com.mc.common.base.BasePresenter;

import java.util.Map;

/**
 * Created by momologo on 2017/12/5 15:15.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public interface BaseAddressPresenter extends BasePresenter {

    void loadAddressList(Map<String, String> pMap);

    void setDefault(Map<String, String> pMap);

    void deleteAddress(Map<String, String> pMap);

    void editAddress(Map<String, String> pMap);

    void addAddress(Map<String, String> pMap);

    void loadArea(Map<String, String> pMap);

    void loadArea();
}

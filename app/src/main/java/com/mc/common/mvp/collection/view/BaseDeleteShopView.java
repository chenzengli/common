package com.mc.common.mvp.collection.view;

import com.mc.common.api.ApiException;
import com.mc.common.base.BaseView;

/**
 * @类名称：BaseDeleteShopView
 * @单位：安徽米创信息技术有限公司
 * @联系人：朱世闯
 * @联系方式：zsc@micjs.com
 * @创建时间：2017/12/11-15:19
 * @功能描述：取消关注店铺的view
 */

public interface BaseDeleteShopView<E extends ApiException> extends BaseView {
    void showLoading();

    void showLoading(String msg);

    void hideLoading();

    void showErrorMsg(E msg);

    void deleteShopSuccess(int position);

    void deleteShopError(String info);
}

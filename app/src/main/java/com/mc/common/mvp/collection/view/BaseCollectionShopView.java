package com.mc.common.mvp.collection.view;

import com.mc.common.api.ApiException;
import com.mc.common.base.BaseView;

/**
 * @类名称：CollectionShopView
 * @单位：安徽米创信息技术有限公司
 * @联系人：朱世闯
 * @联系方式：zsc@micjs.com
 * @创建时间：11:14
 * @功能描述：
 */

public interface BaseCollectionShopView<T extends BaseView, K extends BaseView, E extends ApiException> extends BaseView {

    void showLoading();

    void showLoading(String msg);

    void hideLoading();

    void showErrorMsg(E msg);

    void refreshSuccess(T t);

    void loadMoreSuccess(int totalResult);

    void refreshFail(String errorInfo);

    void loadMoreFail(String errorInfo);

}

package com.mc.common.mvp.collection.view;

import com.mc.common.api.ApiException;
import com.mc.common.base.BaseView;

/**
 * @类名称：CollectionProductView
 * @单位：安徽米创信息技术有限公司
 * @联系人：朱世闯
 * @联系方式：zsc@micjs.com
 * @创建时间：11:14
 * @功能描述：收藏商品的view
 */

public interface BaseCollectionProductView<T extends BaseView, E extends ApiException> extends BaseView {

    void showLoading();

    void showLoading(String msg);

    void hideLoading();

    void showErrorMsg(E msg);

    void refreshProductSuccess(T t);

    void loadMoreSuccess(T t);

    void refreshFail(String errorInfo);

    void loadMoreFail(String errorInfo);

}

package com.mc.common.mvp.collection.view;

import com.mc.common.api.ApiException;
import com.mc.common.base.BaseView;

/**
 * @类名称：BaseDeleteProduct
 * @单位：安徽米创信息技术有限公司
 * @联系人：朱世闯
 * @联系方式：zsc@micjs.com
 * @创建时间：2017/12/11-15:11
 * @功能描述：取消收藏商品的view
 */

public interface BaseDeleteProductView<E extends ApiException> extends BaseView {
    void showLoading();

    void showLoading(String msg);

    void hideLoading();

    void showErrorMsg(E msg);

    void deleteGoodsSuccess(int position);

    void deleteGoodsError(String info);


}

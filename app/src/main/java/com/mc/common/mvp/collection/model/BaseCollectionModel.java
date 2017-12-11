package com.mc.common.mvp.collection.model;

import com.mc.common.base.BaseBean;
import com.mc.common.base.BaseModel;

import java.util.Map;

import rx.Observable;

/**
 * @类名称：common
 * @单位：安徽米创信息技术有限公司
 * @联系人：朱世闯
 * @联系方式：zsc@micjs.com
 * @创建时间：11:43
 * @功能描述：关于收藏商品和店铺的model
 */

public interface BaseCollectionModel<T extends BaseBean> extends BaseModel {

    Observable<T> getProductList(Map<String, String> map);

    Observable<T> getShopList(Map<String, String> map);

    Observable<T> cancelProduct(Map<String, String> map);

    Observable<T> cancelShop(Map<String, String> map);

    Observable<T> addCart(Map<String, String> map);


}

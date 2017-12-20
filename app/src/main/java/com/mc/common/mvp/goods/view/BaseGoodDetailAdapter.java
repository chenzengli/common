package com.mc.common.mvp.goods.view;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;

import java.util.ArrayList;

/**
 * Created by momologo on 2017/12/20 10:42.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public abstract class BaseGoodDetailAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_EVALUATION = 0;
    public static final int TYPE_PARAMETERS = 1;
    public static final int TYPE_COUPON = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     */

    public BaseGoodDetailAdapter() {
        super(new ArrayList<MultiItemEntity>());
        addItemType(TYPE_EVALUATION, R.layout.item_comment_layout);//商品评价
        addItemType(TYPE_PARAMETERS, R.layout.item_product_parameters);//产品参数
        addItemType(TYPE_COUPON, R.layout.item_newest_coupon);//优惠券
    }
}
